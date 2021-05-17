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

<form method="post" id="form" action="<%=path%>/ChangeStaffProfileServlet" >
	<table border="0" align="center">

		<tr>
			<td align="center">changeStaffProfile</td>

		</tr>
		<input type="hidden" name="id" value="${staff.id}" />
		<tr>
			<td align="right">fullName:</td>
			<td><input type="text" name="fullName"  id="fullName" value="${staff.fullName}"/></td>
		</tr>

		</tr>
			<td align="right">mobileNumber:</td>
			<td><input type="text" name="mobileNumber"  id="mobileNumber" value="${staff.mobileNumber}"/></td>
		</tr>

		</tr>
			<td align="right">email:</td>
			<td><input type="text" name="email"  id="email" value="${staff.email}"/></td>
		</tr>

		</tr>
			<td align="right">workHourLimit:</td>
			<td><input type="text" name="workHourLimit"  id="workHourLimit" value="${staff.workHourLimit}"/></td>
		</tr>

		</tr>
			<td align="right">preferredName:</td>
			<td><input type="text" name="preferredName"  id="preferredName" value="${staff.preferredName}"/></td>
		</tr>

		</tr>
			<td align="right">homeAddress:</td>
			<td><input type="text" name="homeAddress"  id="homeAddress" value="${staff.homeAddress}" /></td>
		</tr>

		<tr>
			<td colspan="2" style="width: 100px; height: 50px;">
				<button type="button" name="changeStaffProfile" onclick="changeStaffProfileClick()">changeStaffProfile</button>
			</td>
		</tr>

	</table>
</form>




</body>

<script>
	function changeStaffProfileClick(){

		var fullName = document.getElementById("fullName").value;
		var mobileNumber = document.getElementById("mobileNumber").value;
		var email = document.getElementById("email").value;
		var workHourLimit = document.getElementById("workHourLimit").value;
		var homeAddress = document.getElementById("homeAddress").value;
		if (fullName === ''){
			alert("id is empty！");
			return ;
		}
		if (mobileNumber === ''){
			alert("mobileNumber is empty！");
			return ;
		}
		if (email === ''){
			alert("email empty！");
			return ;
		}
		if (workHourLimit === ''){
			alert("workHourLimit is empty！");
			return ;
		}
		if (homeAddress === ''){
			alert("homeAddress is empty！");
			return ;
		}

		// call servlet
		document.getElementById("form").submit();
	}
</script>
</html>