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

<%
//TODO 跳转回到这个本页面是对的，但是忘了把列表的值读出来。
	//TODO 列表中status字段不能直接展示数字，要不然用户看不懂，可以用判断语句翻译成文字，或者直接在sql语句中判断。
%>
<body>


	<div class="main" style="margin-top: 200px;">


		<br> <br> <br>

		<div align="center">Available shifts to be allocated</div>
		<table align="center">
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
			<c:forEach items="${shiftList}" var="shift" varStatus="status">
				<form id="form${status.index}" method="post">
					<tr>
						<td align="center">${shift.id}</td>
						<input type="hidden" name="id" value="${shift.id}" />
						<td align="center">${shift.staffAllocated}</td>
						<input type="hidden" name="staffId"
							value="${shift.staffAllocated}" />
						<td align="center">${shift.startTime}</td>
						<td align="center">${shift.endTime}</td>
						<td align="center">${shift.duration}</td>
						<td align="center">${shift.location}</td>
						<td align="center">${shift.status}</td>
						<td align="center">${shift.remark}</td>
						<td align="center"><button type="button"
								onclick="accept(${status.index})">accept</button></td>
						<td align="center"><button type="button"
								onclick="reject(${status.index})">reject</button></td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>

</body>

<script>
	function accept(index)
	{
		document.getElementById("form"+index).action="AcceptShiftAllocationServlet";

		document.getElementById("form"+index).submit();
	}

	function reject(index)
	{
		document.getElementById("form"+index).action="RejectShiftAllocationServlet";
		document.getElementById("form"+index).submit();
	}

</script>
</html>