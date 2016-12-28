<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/action/user/login.do" method="post">
    <input type="text" name="name"> <br>
    <input type="password" name="pass"><br>
    <input type="submit" value="登录">
</form>
<hr>
<a href="action/emp/login.do">管理员登录</a>
</body>
</html>
