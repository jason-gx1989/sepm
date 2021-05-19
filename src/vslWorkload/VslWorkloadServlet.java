package vslWorkload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VslWorkloadServlet")
public class VslWorkloadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private VslWorkloadService service = new VslWorkloadService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("weeklyWorkload", service.getWorkloadByStaff(1));
		request.setAttribute("monthlyWorkload", service.getWorkloadByStaff(2));
		
		request.getRequestDispatcher("/vslWorkload.jsp").forward(request, response);
	}
}
