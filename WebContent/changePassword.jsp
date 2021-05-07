<% String path = request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>changePassword</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	String result= (String) request.getAttribute("result");
	if (result == null){
		result = "Welcome!";
	}
%>

<script type="text/javascript" language="javascript">
	alert("<%=result%>");
</script>

<form method="post" id="form" action="<%=path%>/ChangePasswordServlet" >
	<table border="0" align="center">

		<tr>
			<td align="center">changePassword</td>

		</tr>
		<tr>
			<td align="right">fullName:</td>
			<td><input type="text" name="fullName" id="fullName" /></td>
		</tr>
			<td align="right">old password:</td>
			<td><input type="password" name="oldPassword"  id="oldPassword"/></td>
		</tr>
		</tr>
		<td align="right">new password:</td>
		<td><input type="password" name="newPassword"  id="newPassword"/></td>
		</tr>
		</tr>
		<td align="right">new password:</td>
		<td><input type="password" name="newPassword2"  id="newPassword2"/></td>
		</tr>
		<tr>
			<td colspan="2" style="width: 100px; height: 50px;">
				<button type="button" name="changePassword" onclick="changePasswordClick()">changePassword</button>
			</td>
		</tr>

	</table>
</form>




</body>

<script>
	function changePasswordClick(){
		var fullName = document.getElementById("fullName").value;
		var password = document.getElementById("oldPassword").value;
		var password1 = document.getElementById("newPassword").value;
		var password2 = document.getElementById("newPassword2").value;
		if (fullName === ''){
			alert("fullName is empty！");
			return ;
		}
		if (password === ''){
			alert("old password is empty！");
			return ;
		}
		if (password1 === ''){
			alert("new password is empty！");
			return ;
		}
		if (password2 === ''){
			alert("new password is empty！");
			return ;
		}
		if (password1 !== password2){
			alert("The new passwords entered twice are inconsistent！");
			return ;
		}

		// call servlet
		document.getElementById("form").submit();
	}
</script>
</html>