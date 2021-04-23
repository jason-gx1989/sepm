package addshiftManager;

//import Service.ShiftManagerService;

import entity.ShiftManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Staff Controller operation class
 */
@WebServlet("/AddShiftManagerServlet")
public class AddShiftManagerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ShiftManagerService shiftManagerService = new ShiftManagerService();

    @Override
    @SuppressWarnings("unused")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String mobileNumber = request.getParameter("mobileNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        shiftManagerService.addShiftManager(fullName, password, mobileNumber, email);
		request.getRequestDispatcher("/index.jsp").forward(request, response);


    }
}
