package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 230548242053125113L;
	LoginService service = new LoginService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userType = request.getParameter("userType");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// staff manager
		if ("1".equals(userType)) {

			String result = service.managerLogin(email, password);

			if (!"000".equals(result)) {
				request.setAttribute("result", result);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/StaffManagerIndex.jsp").forward(request, response);
			}

		}

		// staff
		if ("2".equals(userType)) {
			String result = service.staffLogin(email, password);

			if (!"000".equals(result)) {
				request.setAttribute("result", result);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/staffIndex.jsp").forward(request, response);
			}
		}

	}
}
