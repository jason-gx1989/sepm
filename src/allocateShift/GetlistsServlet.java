package allocateShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetlistsServlet")
public class GetlistsServlet extends HttpServlet {

	AllocateShiftService service = new AllocateShiftService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Grab staff list from database
		request.setAttribute("shiftList", service.getShiftList());
		request.setAttribute("staffList", service.getStaffList());

		request.getRequestDispatcher("/allocateShift.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}