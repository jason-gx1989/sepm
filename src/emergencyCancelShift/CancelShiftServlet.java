package emergencyCancelShift;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.email.EmailUtiils;
import entity.ShiftManager;

@WebServlet("/CancelShift")
public class CancelShiftServlet extends HttpServlet {

	CancelShiftService service = new CancelShiftService();

	// TODO Servlet只负责收发参数，业务逻辑应该放在service类中。

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read field from view
		String staffId = "1";
		String shiftId = request.getParameter("selectedShiftId");		
		if (shiftId != null) {
			service.cancelShift(Integer.parseInt(shiftId));
			// 发送邮件通知给每一位 Shiftmanager
            service.emailShiftManager(Integer.parseInt(shiftId), Integer.parseInt(staffId));
		}
		// Grab staff list from database
		request.setAttribute("shiftList", service.getStaffShiftList(Integer.parseInt(staffId)));

		request.getRequestDispatcher("/cancelShift.jsp").forward(request, response);
	}

}
