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
		

	</div>

</body>
</html>