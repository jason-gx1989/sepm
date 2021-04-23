package addshiftManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Staff Controller operation class
 */
@WebServlet("/AddShiftManagerServlet")
public class AddShiftManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ShiftManagerService shiftManagerService = new ShiftManagerService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullName = request.getParameter("fullName");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		shiftManagerService.addShiftManager(fullName, password, mobileNumber, email);

		// TODO 因为后续开发中会涉及到在本页面读取所有的ShiftManager，所以请跳转回本页面，向页面上输出“添加成功”之类的字样，以表示添加成功。
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
}
