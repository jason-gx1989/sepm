package listShiftAllocationHistory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listShiftAllocationHistoryServlet")
public class listShiftAllocationHistoryServlet extends HttpServlet{
	
	listShiftAllocationHistoryService service = new listShiftAllocationHistoryService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get staff id
//		String id = req.getParameter("id"); 用户登录后直接pass id
		//get shifts from database
		String id = "1";
		
		req.setAttribute("shiftList", service.listShiftAllocationHistory(id));
		
		req.getRequestDispatcher("/listShiftAllocationHistory.jsp").forward(req, resp);
	}
}
