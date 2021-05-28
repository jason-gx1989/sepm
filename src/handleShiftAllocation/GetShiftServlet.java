package handleShiftAllocation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetShiftServlet")
public class GetShiftServlet extends HttpServlet {

	handleShiftAllocationService service = new handleShiftAllocationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Grab staff list from database
		request.setAttribute("shiftList", service.getShiftList());

		request.getRequestDispatcher("/handleAllocateShift.jsp").forward(request, response);
	}
}
