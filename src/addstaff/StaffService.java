package addstaff;

import entity.Staff;

/**
 * Staff Service operation class
 */
public class StaffService {

	private static StaffDao staffDao = new StaffDao();

	public int createStaff(String fullName, String password, String mobileNumber, String email, String preferredName,
			String homeAddress) {

		// TODO 按照原始需求文档上添加各种字段的判断，虽然jsp上已经判断过了，但是为了让junit和testcase涵盖更广（主要是怕扣分），后台也需要加上。
		// TODO 补充junit和文档中的testcase，所有判断条件的每一个分支都要涵盖到。

		Staff staff = new Staff();
		staff.setFullName(fullName);
		staff.setPassword(password);
		staff.setIsPasswordUpdated(0);
		staff.setMobileNumber(mobileNumber);
		staff.setEmail(email);
		staff.setPreferredName(preferredName);
		staff.setWorkHourLimit(40.0); // default value
		staff.setHomeAddress(homeAddress);

		return staffDao.createStaff(staff);

	}
}
