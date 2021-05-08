<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Import collection and looping package -->
<%@page import="java.util.*"%>
<%@page import="emergencyCancelShift.*"%>
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


	<div class="main" style="margin-top: 200px;">

<div align="center">Shift allocated to you</div>
		<table  align="center" >			
			<tr>
				<td align="center">ShiftID</td>				
				<td align="center">startTime</td>
				<td align="center">endTime</td>
				<td align="center">duration</td>
				<td align="center">location</td>
				<td align="center">status</td>
				<td align="center">remark</td>
			</tr>

			<!-- Print data -->
			<form action="CancelShift" method="post">
			<c:forEach items="${shiftList}" var="shift">				
					<tr>
						<td align="center">${shift.id}</td>
						<td align="center">${shift.startTime}</td>
						<td align="center">${shift.endTime}</td>
						<td align="center">${shift.duration}</td>
						<td align="center">${shift.location}</td>
						<td align="center">${shift.status}</td>
						<td align="center">${shift.remark}</td>
						<td align="center"><input type="radio" name="selectedShiftId" value="${shift.id}" /></td>						
					</tr>				
			</c:forEach>
			<tr align="center"><input  type="submit" value="cancel" /></tr>                                           
			</form>
		</table>
	</div>

</body>
</html>