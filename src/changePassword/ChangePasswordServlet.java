package changePassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;


@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

	ChangePasswordService changePasswordService = new ChangePasswordService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read field from view
		String fullName = request.getParameter("fullName");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");

		System.out.println(newPassword);
		Pattern pattern = Pattern.compile("^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$");
		if (!pattern.matcher(newPassword).matches()){
			request.setAttribute("result", "Invalid Password!  Password must contain uppercase and lowercase letters, numbers and special characters (more than 8 digits in length).");
		}
		int res = changePasswordService.changePassword(fullName, oldPassword, newPassword);
		if (res == 0){
			request.setAttribute("result", "The fullName has not been registered.");
		}else if (res == -1){
			request.setAttribute("result", "The old password is incorrect.");
		}else {
			request.setAttribute("result", "Password has been changed successfully.");
		}

		request.getRequestDispatcher("/changePassword.jsp").forward(request, response);
	}
	
	
}
