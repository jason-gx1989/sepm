package changeLimit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChangeLimitServlet")
public class ChangeLimitServlet extends HttpServlet {

	ChangeLimitService service = new ChangeLimitService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read field from view
		String id = request.getParameter("id");
		String newLimit = request.getParameter("newLimit");
		service.changeLimit(Integer.parseInt(id), Double.parseDouble(newLimit));
		
		// Grab staff list from database
		request.setAttribute("staffList", service.getStaffList());
		
		request.getRequestDispatcher("/changeLimit.jsp").forward(request, response);
	}
	
	
}
