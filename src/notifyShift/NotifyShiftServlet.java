package notifyShift;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import notice.NoticeService;


@WebServlet("/NotifyShiftServlet")
public class NotifyShiftServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	NoticeService service = new NoticeService();

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Pass variables to view
		request.setAttribute("noticeList", service.getNoticeList(1));
		
		
	}
}
