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
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Read field from view
		String staffId = "1";
		String id = request.getParameter("selectedShiftId");
		ArrayList<ShiftManager> shiftmanagers = service.getShiftManagerList();
		if(id!=null)
		{
		service.cancelShift(Integer.parseInt(id));
		//发送邮件通知给每一位 Shiftmanager
		for(ShiftManager shiftmanager:shiftmanagers)
		{
			String address = shiftmanager.getEmail();
			String head = "shift cancellation notification";
			String content = "staffId"+staffId+"has cancelled shiftId"+id+"due to emergency";
			EmailUtiils.sendEmail(address, head, content);
		}		
		}
		// Grab staff list from database
		request.setAttribute("shiftList", service.getStaffShiftList(Integer.parseInt(staffId) ));
		
		request.getRequestDispatcher("/cancelShift.jsp").forward(request, response);
	}
	
	
}

