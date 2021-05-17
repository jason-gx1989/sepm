package deactiveAccount;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeactiveAccountServlet")
public class DeactiveAccountServlet extends HttpServlet{
	
	DeactiveAccountService service = new DeactiveAccountService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int int_id = Integer.parseInt(id);
		String position = request.getParameter("p");
		
		if(position.equals("m")) {
			service.deactiveManagerAccount(int_id);
			request.setAttribute("result", "Manager account has been successfully deactived.");
			
		}
		else {
			service.deactiveStaffAccount(int_id);
			request.setAttribute("result", "Staff account has been successfully deactived.");
		}
		
		request.setAttribute("staffList", service.getStaffList());
		request.setAttribute("shiftManagerList", service.getShiftManagerList());
		
		request.getRequestDispatcher("/deactiveAccount.jsp").forward(request, response);
	}
	
}
