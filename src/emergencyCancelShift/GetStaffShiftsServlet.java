package emergencyCancelShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetStaffShiftsServlet")
public class GetStaffShiftsServlet extends HttpServlet {

	CancelShiftService service = new CancelShiftService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		// Grab staff shifts list from database
		//测试staffid =1后续根据登陆情况调整
		String staffId = "1";
		request.setAttribute("shiftList", service.getStaffShiftList(Integer.parseInt(staffId)));

		request.getRequestDispatcher("/cancelShift.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}