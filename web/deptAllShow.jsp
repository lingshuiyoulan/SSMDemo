<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门地址</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${depts}" var="item">
        <tr>
            <td>${item.deptno}</td>
            <td>${item.dname}</td>
            <td>${item.loc}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
