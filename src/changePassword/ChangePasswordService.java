package changePassword;

import entity.Staff;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class ChangePasswordService {

	ChangePasswordDao changePasswordDao = new ChangePasswordDao();

	
	public int changePassword(String fullName, String oldPassword, String newPassword) {
		Pattern pattern = Pattern.compile("^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$");
		if (!pattern.matcher(newPassword).matches()){
		return -2;
		}else {
			return changePasswordDao.changePassword(fullName, oldPassword, newPassword);
		}
	}

}
