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
	<%-- 	<%
	Integer id = (Integer) request.getAttribute("id");
		if (null == id) {
			id = 0;
		}
	%> --%>

	<div class="main" style="margin-top: 200px;">
		<form action="TestServlet" method="post">
			<table border="0" align="center">

				<!-- <tr>
					<td align="right">email:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td align="right">password:</td>
					<td><input type="text" name="password" /></td>
				</tr> -->


				<input type="text" name="userType" />
				<tr>
					<td colspan="2" style="width: 100px; height: 50px;"><span
						id="msg"> <%-- <%=id%> --%>
					</span> <input type="submit" value="xxx" style="width: 100px" /></td>
				</tr>

			</table>
		</form>
		<!-- <button type="button" name="notification" onclick="sendNotification()">notification</button> -->
	</div>

</body>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script>
	function systemConsole() {
		/* console.log("xxxxxxxx"); */
		sendNotification();
	}
	setInterval(systemConsole, 1000);

	function sendNotification() {
		$.ajax({
			url : 'TestAjaxServlet',
			data : {
				userid : '1'
			},
			type : "post",
			success : function(data) {
				/* alert(data); */

				openwindow = window.open("", "newwin","height=250, width=250,toolbar=no,scrollbars=" + scroll+ ",menubar=no");
				//εζδΈθ‘ 
				openwindow.document.write("<title>notice</title>")
				openwindow.document.write("<body bgcolor=#ffffff>")
				openwindow.document.write(data)
				openwindow.document.write("</body>")
				openwindow.document.write("</html>")
				openwindow.document.close(); 
			}
		});

	}
</script>
</html>