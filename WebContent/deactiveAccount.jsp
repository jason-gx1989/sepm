<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Import collection and looping package -->
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("UTF-8");
String result = (String) request.getAttribute("result");
if (result == null)
	result = "";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deactive Account</title>
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

	<input type="hidden" name="alertStr" id="alertStr" value=<%=result%> />

	<div class="main" style="margin-top: 200px;">

		<table  border="0" align="center">
			<tr>
				<b>ShiftManager</b>
			</tr>
			<!-- Print table header -->
			<tr>
				<td align="center">ID</td>
				<td align="center">Full Name</td>
				<td align="center">mobileNumber</td>
				<td align="center">email</td>
				
			</tr>
			<br>
			<!-- Print data -->
			<c:forEach items="${shiftManagerList}" var="shiftManager">
				<form action="ChangeLimitServlet" method="post" id="form">
					<tr>
						<td align="center">${shiftManager.id}</td>
						<input type="hidden" name="id" value="${shiftManager.id}" />
						<td align="center">${shiftManager.fullName}</td>
						<td align="center">${shiftManager.mobileNumber}</td>
						<td align="center">${shiftManager.email}</td>
						<td><a href="DeactiveAccountServlet?id=${shiftManager.id}&p=m">Delete</a></td>
					</tr>
				</form>
			</c:forEach>
		</table>

		<br>
		<br>
		<table  border="0" align="center">
			<tr>
				<b>Staff</b>
			</tr>
			<br>
			<!-- Print table header -->
			<tr>
				<td align="center">ID</td>
				<td align="center">Full Name</td>
				<td align="center">mobileNumber</td>
				<td align="center">email</td>
				<td align="center">preferredName</td>
				<td align="center">homeAddress</td>
				<td align="center">work Limit</td>
				<td align="center"></td>
			</tr>

			<!-- Print data -->
			<c:forEach items="${staffList}" var="staff">
				<form action="ChangeLimitServlet" method="post" id="form">
					<tr>
						<td align="center">${staff.id}</td>
						<input type="hidden" name="id" value="${staff.id}" />
						<td align="center">${staff.fullName}</td>
						<td align="center">${staff.mobileNumber}</td>
						<td align="center">${staff.email}</td>
						<td align="center">${staff.preferredName}</td>
						<td align="center">${staff.homeAddress}</td>
						<td><a href="DeactiveAccountServlet?id=${staff.id}&p=s">Delete</a></td>
						
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>
</body>

<script type="text/javascript" language="javascript">
	var s = document.getElementById("alertStr").value;
	if ('<%=result%>' !== '') {
		alert('<%=result%>');
	}
</script>

</html>