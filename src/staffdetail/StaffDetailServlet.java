package staffdetail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StaffDetailServlet")
public class StaffDetailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String staffId = request.getParameter("staffId");

		// TODO step1：读取一个关于单个staff的shift列表，展示在staffDetail.jsp上。

		// TODO step2：参考changeLimit.jsp的展示方式，更新shift的status字段。

	}
}
