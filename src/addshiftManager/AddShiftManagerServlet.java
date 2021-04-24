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

        int i = shiftManagerService.addShiftManager(fullName, password, mobileNumber, email);

        if (i != 1){
            request.setAttribute("result", "Add ERROR");
        }else {
            request.setAttribute("result", "Add SUCCESS");
        }

        request.getRequestDispatcher("/addShiftManager.jsp").forward(request, response);
	}
}
