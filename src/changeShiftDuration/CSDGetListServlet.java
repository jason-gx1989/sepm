package changeShiftDuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CSDGetlistServlet")
public class CSDGetListServlet extends HttpServlet {

	ChangeShiftDurationService service = new ChangeShiftDurationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read field from view

		// Grab staff list from database
		request.setAttribute("shiftList", service.getShiftList());		

		request.getRequestDispatcher("/changeShiftDuration.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}