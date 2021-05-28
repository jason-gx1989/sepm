package staffdetail.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StaffCalendarServlet")
public class StaffCalendarServlet extends HttpServlet {

	StaffCalendarService service = new StaffCalendarService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int staffId = Integer.valueOf(request.getParameter("staffId"));
		int year = Integer.valueOf(request.getParameter("year"));
		int month = Integer.valueOf(request.getParameter("month"));

		String result = service.getCalendarStr(staffId, year, month);

		response.setContentType("text/plain"); 
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);

	}
}
