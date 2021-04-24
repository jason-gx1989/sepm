package addstaff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Staff Controller operation class
 */
@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StaffService staffService = new StaffService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullName = request.getParameter("fullName");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String preferredName = request.getParameter("preferredName");
		String homeAddress = request.getParameter("homeAddress");
		String password = request.getParameter("password");

		int i = staffService.createStaff(fullName, password, mobileNumber, email, preferredName, homeAddress);

		if (i != 1) {
			request.setAttribute("result", "Add ERROR");
		} else {
			request.setAttribute("result", "Add SUCCESS");
		}

		request.getRequestDispatcher("/addStaff.jsp").forward(request, response);

	}
}
