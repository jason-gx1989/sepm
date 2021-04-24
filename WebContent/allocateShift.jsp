<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Import collection and looping package -->
<%@page import="java.util.*"%>
<%@page import="allocateShift.*"%>
<%@page import="changeLimit.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<% 
AllocateShiftService service = new AllocateShiftService();
request.setAttribute("shiftList", service.getShiftList());
ChangeLimitService service2 = new ChangeLimitService();
request.setAttribute("staffList", service2.getStaffList());
%>

	<div class="main" style="margin-top: 200px;">

		<table border="0" align="center">

			<!-- Print table header -->
			
			<tr align="center">
			Available shifts to be allocated
			</tr>
			<tr>
				<td align="center">ShiftID</td>
				<td align="center">allocatedStaffID</td>
				<td align="center"></td>
			</tr>

			<!-- Print data -->
			<c:forEach items="${shiftList}" var="shift">
				<form action="AllocateShift" method="post">
				<tr>
					<td align="center">${shift.id}</td>
					<input type="hidden" name="id" value="${shift.id}" />
					<td><input type="text" name="staffAllocated" value="${shift.staffAllocated}" /></td>
					<td align="center"><input type="submit" value="allocate" /></td>
				</tr>
				</form>
			</c:forEach>
		</table>
<br>

<table  border="0" align="center">
            <tr align="center">
                   Available staffs
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

</table >


	</div>

</body>
</html>