<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<style type="text/css">
#span {
	color: red;
	font-wight: bold;
}

.main {
	text-align: center;
	background-color: #fff;
	/* border-radius: 20px; */
	/* width: 300px;
            height: 350px;
            margin: auto; */
	/* position: absolute; */
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
}
</style>
</head>
<body>
	<%
	Integer id = (Integer) request.getAttribute("id");
		if (null == id) {
			id = 0;
		}
	%>

	<div class="main" style="margin-top: 200px;">
		<form action="TestServlet" method="post">
			<table border="0" align="center">

				<tr>
					<td><a href="AddShift.jsp">Add Shift</a></td>
				</tr>
				<tr>
					<td><a href="addShiftManager.jsp">Add Shift Manager</a></td>
				</tr>
				<tr>
					<td><a href="changePassword.jsp">change Password</a></td>
				</tr>
				<tr>
					<td><a href="addStaff.jsp">Add Staff</a></td>
				</tr>
				<tr>
					<td><a href="GetlistsServlet">Allocate Shift</a></td>
				</tr>
				<tr>
					<td><a href="GetStaffServlet">Change Limit</a></td>
				</tr>

			</table>



		</form>

	</div>

</body>
</html>