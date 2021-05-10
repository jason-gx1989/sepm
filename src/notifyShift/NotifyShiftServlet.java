package notifyShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Notice;
import notice.NoticeService;


@WebServlet("/NotifyShiftServlet")
public class NotifyShiftServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	NoticeService service = new NoticeService();

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Notice notice = service.getNotice(1, "1");
		
		if (notice != null) {
			int id = notice.getId();
			service.updateStatus(id, "1");
			
			// Pass variables to view
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("You have a notification regarding shift allocation (received on " + notice.getSendTime() + ")");
		}
		else {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("-1");
		}
	}
}
