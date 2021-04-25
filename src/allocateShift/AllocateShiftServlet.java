package allocateShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AllocateShift")
public class AllocateShiftServlet extends HttpServlet {

	AllocateShiftService service = new AllocateShiftService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read field from view
		String id = request.getParameter("id");
		String staffAllocated = request.getParameter("staffAllocated");
		service.allocateShift(Integer.parseInt(id), Integer.parseInt(staffAllocated));
		
		// Grab staff list from database
		request.setAttribute("shiftList", service.getShiftList());
		request.setAttribute("staffList", service.getStaffList());
		
		request.getRequestDispatcher("/allocateShift.jsp").forward(request, response);
	}
	
	
}
