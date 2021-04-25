<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Import collection and looping package -->
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Work Limit</title>
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

	<div class="main" style="margin-top: 200px;">

		<table border="0" align="center">

			<!-- Print table header -->
			<tr>
				<td align="center">ID</td>
				<td align="center">Full Name</td>
				<td align="center">Work Limit</td>
				<td align="center"></td>
			</tr>

			<!-- Print data -->
			<c:forEach items="${staffList}" var="staff">
				<form action="ChangeLimitServlet" method="post">
				<tr>
					<td align="center">${staff.id}</td>
					<input type="hidden" name="id" value="${staff.id}" />
					<td align="center">${staff.fullName}</td>
					<td><input type="text" name="newLimit" value="${staff.workHourLimit}" /></td>
					<td align="center"><input type="submit" value="Change"
						style="width: 100px" /></td>
				</tr>
				</form>
			</c:forEach>
		</table>





	</div>

</body>
</html>