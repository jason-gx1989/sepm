package deactiveAccount;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetDetailsServlet")
public class GetDetailsServlet extends HttpServlet{
	
	DeactiveAccountService service = new DeactiveAccountService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("staffList", service.getStaffList());
		request.setAttribute("shiftManagerList", service.getShiftManagerList());
		
		request.getRequestDispatcher("/deactiveAccount.jsp").forward(request, response);
	}
}