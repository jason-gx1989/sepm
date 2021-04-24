package addshift;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddShiftServlet")
public class AddShiftServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	AddShiftService service = new AddShiftService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String duration = request.getParameter("duration");
		String location = request.getParameter("location");
		String staffAllocated = request.getParameter("staffAllocated");
		String remark = request.getParameter("remark");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");

		String result = service.addShift(startTime, endTime, duration, location, staffAllocated, remark);
		if ("01".equals(result)) {
			String s = "Invalid Time Format"; 
			request.setAttribute("s", s);
			request.getRequestDispatcher("/AddShift.jsp").forward(request, response);// TODO
		}
		if ("02".equals(result)) {
			String s = "Invalid Time Format"; 
			request.setAttribute("s", s);
			request.getRequestDispatcher("/AddShift.jsp").forward(request, response);// TODO
		}

		request.getRequestDispatcher("/AllocateShift").forward(request, response);

	}
}
