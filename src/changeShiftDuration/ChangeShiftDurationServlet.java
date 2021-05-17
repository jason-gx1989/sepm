package changeShiftDuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import notice.NoticeService;


@WebServlet("/ChangeShiftDuration")
public class ChangeShiftDurationServlet extends HttpServlet {
	
	ChangeShiftDurationService service = new ChangeShiftDurationService();	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read field from view
		String id = request.getParameter("id");
		String duration = request.getParameter("duration");
		service.changeShiftDuration(Integer.parseInt(id), Double.parseDouble(duration));
		
		// Grab staff list from database
		request.setAttribute("shiftList", service.getShiftList());
		
		request.getRequestDispatcher("/changeShiftDuration.jsp").forward(request, response);
	}
	
	
}