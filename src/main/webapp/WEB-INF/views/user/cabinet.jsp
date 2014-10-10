<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.10.3
  Time: 12.32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${user.name}</title>
</head>
<body>
<jsp:include page="../static/header.jsp"/>
<div style="text-align: center">
    <h1>User's info</h1>
    Login: ${user.login}<br>
    Email: ${user.email}<br>
    Role: ${user.role.role}<br>
    Tasks<br>
    <c:forEach items="${user.stories}" var="story">
        <a href="/story.htm?id=${story.id}">${story.title}</a><br>
    </c:forEach>
</div>
</body>
</html>