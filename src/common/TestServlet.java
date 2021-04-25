package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ShiftManager;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

//	TestService service = new TestService();
	//
	//
	//

	@Override
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		service.add(email, password);
//		ShiftManager s = service.find(email);
//
//		request.setAttribute("id", s.getId());

		String userType = request.getParameter("userType");

		// manager
		if ("1".equals(userType)) {

			request.getRequestDispatcher("/shiftManagerindex.jsp").forward(request, response);

		}

		// staff
		if ("2".equals(userType)) {

			request.getRequestDispatcher("/test.jsp").forward(request, response);

		}

	}
}