package addshift;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddShiftServlet")
public class AddShiftServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	AddShiftService service = new AddShiftService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Date startTime = Date.valueOf(request.getParameter("startTime"));
//		Date endTime = Date.valueOf(request.getParameter("endTime"));
		double duration = Double.valueOf(request.getParameter("duration"));
		String location = request.getParameter("location");
		int staffAllocated = Integer.valueOf(request.getParameter("staffAllocated"));
		int status = Integer.valueOf(request.getParameter("status"));
		String remark = request.getParameter("remark");
		Date nowdate =new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime = Timestamp.valueOf(simpleDate.format(nowdate));
		Date endTime = Timestamp.valueOf(simpleDate.format(nowdate));
		service.addShift(startTime, endTime , duration, location, staffAllocated, status, remark);
		System.out.println(duration + location + staffAllocated + status + remark);
		request.getRequestDispatcher("/test.jsp").forward(request, response);

	}
}
