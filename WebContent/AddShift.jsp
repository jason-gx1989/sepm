<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Shift</title>
<style type="text/css">
#span {
	color: red;
	font-wight: bold;
}

.main {
	text-align: center;
	/*让div内部文字居中*/
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
	String msg = (String) request.getAttribute("s");
		if (null == msg) {
			msg = "";
		}
	%>

	<div class="main" style="margin-top: 200px;">
		<form action="AddShiftServlet" method="post">
			<table border="0" align="center">

				<tr>
					<td align="right">Start Time:</td>
					<td><input type="text" name="startTime" /></td>
				</tr>
				<tr>
					<td align="right">End Time:</td>
					<td><input type="text" name="endTime" /></td>
				</tr>
				<tr>
					<td align="right">Duration:</td>
					<td><input type="text" name="duration" /></td>
				</tr>
				<tr>
					<td align="right">Location:</td>
					<td><input type="text" name="location" /></td>
				</tr>
				<tr>
					<td align="right">Staff Allocated:</td>
					<td><input type="text" name="staffAllocated" /></td>
				</tr>
				<tr>
					<td align="right">Status:</td>
					<td><input type="text" name="status" /></td>
				</tr>
				<tr>
					<td align="right">Remark:</td>
					<td><input type="text" name="remark" /></td>
				</tr>
				<tr>
					<td colspan="2" style="width: 100px; height: 50px;">
					<%=msg%><input type="submit" value="Add Shift"
						style="width: 100px" /></td>
				</tr>
				<tr>
					<td colspan="2"><img
						src="https://mytestdbgx.s3.amazonaws.com/download.jpeg" /></td>
				</tr>

			</table>



		</form>

	</div>

</body>
</html>