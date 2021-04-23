package changeLimit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetStaffServlet") // TODO servlet命名一般叫xxxServlet，这里我先给你改了，下次注意就行了。
public class GetStaffServlet extends HttpServlet {

	ChangeLimitService service = new ChangeLimitService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Grab staff list from database
		request.setAttribute("staffList", service.getStaffList());

		request.getRequestDispatcher("/changeLimit.jsp").forward(request, response);
	}
}
