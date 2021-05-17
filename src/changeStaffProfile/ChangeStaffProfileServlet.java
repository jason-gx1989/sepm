package changeStaffProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ChangeStaffProfileServlet")
public class ChangeStaffProfileServlet extends HttpServlet {

	ChangeStaffProfileService changeStaffProfileService = new ChangeStaffProfileService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read field from view
		int id = Integer.parseInt(request.getParameter("id")) ;
		String fullName = request.getParameter("fullName");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String workHourLimit = request.getParameter("workHourLimit");
		String preferredName = request.getParameter("preferredName");
		String homeAddress = request.getParameter("homeAddress");


		int res = changeStaffProfileService.changeStaffProfile(id, fullName, mobileNumber, email, workHourLimit, preferredName, homeAddress);
		if (res == 0){
			request.setAttribute("result", "The id has not been registered.");
		}else {
			request.setAttribute("result", "Profile has been changed successfully.");
		}

		request.getRequestDispatcher("/changeStaffProfile.jsp").forward(request, response);
	}
	
	
}
