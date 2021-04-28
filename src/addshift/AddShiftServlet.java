package addshift;

import java.io.IOException;

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
		String remark = request.getParameter("remark");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");

		String result = service.addShift(startTime, endTime, duration, location, remark);
		if ("01".equals(result)) {
			String s = "Invalid Time Format";
			request.setAttribute("s", s);
			request.getRequestDispatcher("/AddShift.jsp").forward(request, response);
		}
		if ("02".equals(result)) {
			String s = "Invalid Time Format";
			request.setAttribute("s", s);
			request.getRequestDispatcher("/AddShift.jsp").forward(request, response);
		}
		if ("03".equals(result)) {
			String s = "Invalid Duration Format";
			request.setAttribute("s", s);
			request.getRequestDispatcher("/AddShift.jsp").forward(request, response);
		}
		if ("04".equals(result)) {
			String s = "Location can't be null!";
			request.setAttribute("s", s);
			request.getRequestDispatcher("/AddShift.jsp").forward(request, response);
		}

		request.getRequestDispatcher("/GetlistsServlet").forward(request, response);

	}
}
