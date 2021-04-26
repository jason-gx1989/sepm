package addshiftManager;

import entity.ShiftManager;

import java.sql.Date;

/**
 * Staff Service operation class
 */
public class ShiftManagerService {

	private static ShiftManagerDao shiftManagerDao = new ShiftManagerDao();

	public int addShiftManager(String fullName, String password, String mobileNumber, String email) {

		// TODO 按照原始需求文档上添加各种字段的判断，虽然jsp上已经判断过了，但是为了让junit和testcase涵盖更广（主要是怕扣分），后台也需要加上。
		// TODO 补充junit和文档中的testcase，所有判断条件的每一个分支都要涵盖到。

		ShiftManager shiftManager = new ShiftManager();
//		shiftManager.setId(Math.abs((int) System.currentTimeMillis()));
		shiftManager.setFullName(fullName);
		shiftManager.setPassword(password);
		shiftManager.setIsPasswordUpdated(0);
		shiftManager.setMobileNumber(mobileNumber);
		shiftManager.setEmail(email);
		shiftManager.setCreateTIme(new Date(System.currentTimeMillis()));

		return shiftManagerDao.addShiftManager(shiftManager);

	}
}
