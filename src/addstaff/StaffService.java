package addstaff;

import entity.Staff;

/**
 * Staff Service operation class
 */
public class StaffService {

	private static StaffDao staffDao = new StaffDao();

	public int createStaff(String fullName, String password, String mobileNumber, String email, String preferredName,
			String homeAddress) {

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
