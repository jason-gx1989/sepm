package changeLimit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetStaffAndShiftManagerServlet")
public class GetStaffAndShiftManagerServlet extends HttpServlet {

	ChangeLimitService service = new ChangeLimitService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Grab staff list from database
		request.setAttribute("staffList", service.getStaffList());
		request.setAttribute("shiftManagerList", service.getShiftManagerList());

		request.getRequestDispatcher("/changeLimit.jsp").forward(request, response);
	}
}
