package changePassword;


public class ChangePasswordService {

	ChangePasswordDao changePasswordDao = new ChangePasswordDao();

	
	public int changePassword(String fullName, String oldPassword, String newPassword) {
		
		return changePasswordDao.changePassword(fullName, oldPassword, newPassword);
	}

}
