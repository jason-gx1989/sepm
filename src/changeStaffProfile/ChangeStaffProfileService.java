package changeStaffProfile;


import entity.Staff;

public class ChangeStaffProfileService {

	ChangeStaffProfileDao changeStaffProfileDao = new ChangeStaffProfileDao();


	public int changeStaffProfile(int id, String fullName, String mobileNumber, String email, String workHourLimit, String preferredName, String homeAddress) {

		return changeStaffProfileDao.changeStaffProfile(id, fullName, mobileNumber, email, workHourLimit, preferredName, homeAddress);

	}

	public Staff getStaffProfile(int id){

		return changeStaffProfileDao.getStaffProFile(id);
	}
}
