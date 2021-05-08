package allocateShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import notice.NoticeService;


@WebServlet("/AllocateShift")
public class AllocateShiftServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AllocateShiftService service = new AllocateShiftService();
	NoticeService noticeService = new NoticeService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read field from view
		String id = request.getParameter("id");
		String staffAllocated = request.getParameter("staffAllocated");
		service.allocateShift(Integer.parseInt(id), Integer.parseInt(staffAllocated));
		
		// Insert new notification into database
		// TODO change the hard-coded arguments
		noticeService.insertNotice("1", 1, Integer.parseInt(id));
		
		// Grab staff list from database
		request.setAttribute("shiftList", service.getShiftList());
		request.setAttribute("staffList", service.getStaffList());
		
		request.getRequestDispatcher("/allocateShift.jsp").forward(request, response);
	}
	
	
}
