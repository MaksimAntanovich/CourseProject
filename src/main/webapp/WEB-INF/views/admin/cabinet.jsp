<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.10.13
  Time: 19.04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>User</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
        <th>Actions</th>
            <td>${user.login}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
