<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/action/emp/login.do" method="post">
    <input type="text" name="name"> <br>
    <input type="password" name="pass"><br>
    <input type="submit" value="登录">
</form>
<hr>
</body>
</html>
