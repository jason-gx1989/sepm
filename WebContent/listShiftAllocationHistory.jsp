<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Import collection and looping package -->
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
/*String result = request.getAttribute("allocationHistory");
if (result == null)
	result = "";*/
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Shift Allocation History</title>
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
				<td align="center">Start Time</td>
				<td align="center">End Time</td>
				<td align="center">Duration</td>
				<td align="center">Location</td>
				<td align="center">Staff Allocated</td>
				<td align="center">Status</td>
				<td align="center">Remark</td>
				<td align="center"></td>
			</tr>

			<!-- Print data -->
			<c:forEach items="${shiftList}" var="shift">
				<tr>
					<td align="center">${shift.id}</td>
					<td align="center">${shift.startTime}</td>
					<td align="center">${shift.endTime}</td>
					<td align="center">${shift.duration}</td>
					<td align="center">${shift.location}</td>
					<td align="center">${shift.staffAllocated}</td>
					<td align="center">${shift.status}</td>
					<td align="center">${shift.remark}</td>
					<td align="center"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>