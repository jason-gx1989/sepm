package addshiftManager;

import entity.ShiftManager;

import java.sql.Date;

/**
 * Staff Service operation class
 */
public class ShiftManagerService {

	private static ShiftManagerDao shiftManagerDao = new ShiftManagerDao();

	public int addShiftManager(String fullName, String password, String mobileNumber, String email) {

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
