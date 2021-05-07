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

		// 返回一个数组，数组里是当前月所有有安排的日子。前端接到数组后判断，如果日期出现在数组中，则表示有安排。

		String result = service.getCalendarStr(staffId, year, month);
//		request.setAttribute("result", result);
//		request.getRequestDispatcher("/staffcalendar.jsp").forward(request, response);

		response.setContentType("text/plain"); // Set content type of the response so that jQuery knows what it can
												// expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		response.getWriter().write(result);

	}
}
