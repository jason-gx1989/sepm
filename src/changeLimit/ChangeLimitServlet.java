package changeLimit;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChangeLimitServlet")
public class ChangeLimitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ChangeLimitService service = new ChangeLimitService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read field from view
		String id = request.getParameter("id");
		String newLimit = request.getParameter("newLimit");
		
		Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]{1})?$");
		
		if (!pattern.matcher(newLimit).matches())
			request.setAttribute("result", "Invalid work limit! Please input a positive number with at most one decimal place.");
		else {
			service.changeLimit(Integer.parseInt(id), Double.parseDouble(newLimit));
			request.setAttribute("result", "Work limit has been changed successfully.");
		}
		
		// Grab staff list from database
		request.setAttribute("staffList", service.getStaffList());
		
		request.getRequestDispatcher("/changeLimit.jsp").forward(request, response);
	}
	
	
}
