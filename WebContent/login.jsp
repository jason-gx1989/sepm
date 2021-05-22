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
	String result = (String) request.getAttribute("result");
		if (null == result) {
			result = "";
		}
	%>

	<div class="main" style="margin-top: 200px;">
		<form action="LoginServlet" method="post">
			<table border="0" align="center">

				<tr>
					<td align="right">userType:</td>
					<td><select name="userType" id="userType">
							<option value="1">Staff Manager</option>
							<option value="2">Staff</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">email:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td align="right">password:</td>
					<td><input type="text" name="password" /></td>
				</tr>

				<tr>
					<td colspan="2" style="width: 100px; height: 50px;"><span
						id="msg"> <%=result%>
					</span> <input type="submit" value="login" style="width: 100px" /></td>
				</tr>

			</table>
		</form>
	</div>

</body>
<!-- <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script> -->

</html>