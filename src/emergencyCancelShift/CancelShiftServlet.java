package emergencyCancelShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CancelShift")
public class CancelShiftServlet extends HttpServlet {

	CancelShiftService service = new CancelShiftService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read field from view
		String staffId = "1";
		String id = request.getParameter("selectedShiftId");
		if(id!=null)
		service.cancelShift(Integer.parseInt(id));				
		
		// Grab staff list from database
		request.setAttribute("shiftList", service.getStaffShiftList(Integer.parseInt(staffId) ));
		
		request.getRequestDispatcher("/cancelShift.jsp").forward(request, response);
	}
	
	
}

