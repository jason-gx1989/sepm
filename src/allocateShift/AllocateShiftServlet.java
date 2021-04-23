package allocateShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AllocateShift")
public class AllocateShiftServlet extends HttpServlet {

	AllocateShiftService service = new AllocateShiftService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//TODO 功能缺失：1.需要从数据库读取staff和shift两个list
		//TODO 功能缺失：2.jsp中只见到一个list，还差一个list和allocate功能。
		
		// Read field from view
		String id = request.getParameter("id");
		String staffAllocated = request.getParameter("staffAllocated");
		service.allocateShift(Integer.parseInt(id), Integer.parseInt(staffAllocated));
		
		// Grab staff list from database
		request.setAttribute("shiftList", service.getShiftList());
		
		request.getRequestDispatcher("/allocateShift.jsp").forward(request, response);
	}
	
	
}
