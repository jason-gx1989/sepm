package handleShiftAllocation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;


@WebServlet("/RejectShiftAllocationServlet")
public class RejectShiftAllocationServlet extends HttpServlet {

	handleShiftAllocationService service = new handleShiftAllocationService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read field from view
		String id = request.getParameter("id");
		String staffId = request.getParameter("staffId");

		service.RejectAllocation(Integer.parseInt(id), Integer.parseInt(staffId));
		request.setAttribute("result", "Work limit has been changed successfully.");


		request.getRequestDispatcher("/handleAllocateShift.jsp").forward(request, response);

	}
	
	
}
