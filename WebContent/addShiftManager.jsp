<% String path = request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>addShiftManager</title>
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


    <form method="post" id="form" action="<%=path%>/addShiftManager" >
        <table border="0" align="center">

            <tr>
                <td align="center">addShiftManager</td>

            </tr>
            <tr>
                <td align="right">fullName:</td>
                <td><input type="text" name="fullName"  id="fullName" /></td>
            </tr>
            <tr>
                <td align="right">email:</td>
                <td><input type="text" name="email"  id="email"/></td>
            </tr>
            <tr>
                <td align="right">mobileNumber:</td>
                <td><input type="text" name="mobileNumber"  id="mobileNumber"/></td>
            </tr>
            <tr>
                <td align="right">password:</td>
                <td><input type="password" name="password" id="password" /></td>
            </tr>
            <tr>
                <td colspan="2" style="width: 100px; height: 50px;">
                    <button type="button" name="signIn" onclick="signInClick()">Add Shift Manager</button>
                </td>
            </tr>

        </table>
    </form>


<%--    <form method="post" id="form" action="<%=path%>/addShiftManager" >--%>
<%--        <input type="text" id ="email" name="email" placeholder="">--%>
<%--        <input type="password" id ="password" name="password" placeholder="">--%>
<%--        <button type="button" name="signIn" onclick="signIn()">Sign In</button>--%>
<%--    </form>--%>

</body>

<script>
    function signInClick(){

        var fullName = document.getElementById("fullName").value;
        var mobileNumber = document.getElementById("mobileNumber").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        if (fullName === ''){
            alert("fullName is empty！");
            return ;
        }
        if (mobileNumber === ''){
            alert("mobileNumber is empty！");
            return ;
        }
        if (email === ''){
            alert("email is empty！");
            return ;
        }
        if (password === ''){
            alert("password is empty！");
            return ;
        }
        // call servlet
        document.getElementById("form").submit();
    }
</script>
</html>