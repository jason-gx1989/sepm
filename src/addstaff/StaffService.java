package addstaff;

import entity.Staff;

import java.sql.Date;

/**
 * Staff Service operation class
 */
public class StaffService {

	private static StaffDao staffDao = new StaffDao();

	public int createStaff(String fullName, String password, String mobileNumber, String email, String preferredName,
			String homeAddress) {

		Staff staff = new Staff();
		staff.setId(Math.abs((int) System.currentTimeMillis()));// TODO 不需要自己设置ID，数据库会自增。
		staff.setFullName(fullName);
		staff.setPassword(password);
		staff.setIsPasswordUpdated(0);
		staff.setMobileNumber(mobileNumber);
		staff.setEmail(email);
		staff.setPreferredName(preferredName);
		staff.setWorkHourLimit(5.6); // default value
		staff.setHomeAddress(homeAddress);
		staff.setCreateTIme(new Date(System.currentTimeMillis()));// TODO 这个时间至少需要精确到小时，因为后续可能涉及到计算。

		return staffDao.createStaff(staff);

	}
}
