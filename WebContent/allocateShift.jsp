<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Import collection and looping package -->
<%@page import="java.util.*"%>
<%@page import="allocateShift.*"%>
<%@page import="changeLimit.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String result = (String) request.getAttribute("result");
if (result == null)
	result = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Allocate shifts</title>
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
			<tr align="center">Available staffs
			</tr>
			<tr>
				<td align="center">ID</td>
				<td align="center">Full Name</td>
				<td align="center">Work Limit</td>
				<td align="center"></td>
			</tr>

			<c:forEach items="${staffList}" var="staff">

				<tr>
					<td align="center">${staff.id}</td>
					<td align="center">${staff.fullName}</td>
					<td align="center">${staff.workHourLimit}</td>
				</tr>

			</c:forEach>

		</table>
		<br>		
		<br>		
		<br>

<div align="center">Available shifts to be allocated
</div>
		<table  align="center" >			
			<tr>
				<td align="center">ShiftID</td>
				<td align="center">allocatedStaffID</td>
				<td align="center">startTime</td>
				<td align="center">endTime</td>
				<td align="center">duration</td>
				<td align="center">location</td>
				<td align="center">status</td>
				<td align="center">remark</td>
			</tr>

			<!-- Print data -->
			<c:forEach items="${shiftList}" var="shift">
				<form action="AllocateShift" method="post">
					<tr>
						<td align="center">${shift.id}</td>
						<input type="hidden" name="id" value="${shift.id}" />
						<td><input type="text" name="staffAllocated"
							value="${shift.staffAllocated}" /></td>
						<td align="center">${shift.startTime}</td>
						<td align="center">${shift.endTime}</td>
						<td align="center">${shift.duration}</td>
						<td align="center">${shift.location}</td>
						<td align="center">${shift.status}</td>
						<td align="center">${shift.remark}</td>
						<td align="center"><input type="submit" value="allocate" /></td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>

</body>
<script type="text/javascript" language="javascript">
	
	if ('<%=result%>' !== '') {
		alert('<%=result%>');
	}
</script>
</html>