package login;

import entity.ShiftManager;
import entity.Staff;

public class LoginService {

	LoginDao dao = new LoginDao();

	public String staffLogin(String email, String password) {

		Staff staff = dao.getLoginStaffByEmail(email);

		if (null == staff) {
			return "no such staff in database!";
		}

		if (!password.equals(staff.getPassword())) {
			return "the password entered is incorrect.";
		}

		return "000";
	}

	public String managerLogin(String email, String password) {

		ShiftManager manager = dao.getLoginManagerByEmail(email);

		if (null == manager) {
			return "no such manager in database!";
		}

		if (!password.equals(manager.getPassword())) {
			return "the password entered is incorrect.";
		}

		return "000";
	}

}
