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
					<td align="center"><input type="submit" value="allocate"
						style="width: 100px" /></td>
				</tr>
				</form>
			</c:forEach>
		</table>





	</div>

</body>
</html>