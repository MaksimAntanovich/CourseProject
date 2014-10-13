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
    <title>${user.login}</title>
</head>
<body>
<jsp:include page="../static/header.jsp"/>
<div style="text-align: center">
    <h1>Hello, ${user.login}</h1>
    <h3>Your stories</h3>
    <c:if test="${not empty user.stories}">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Story Title</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user.stories}" var="story">
            <tr>
                <td>${story.title}</td>
                <td>
                    <div class="btn-group">
                        <a class="btn btn-primary" href="/story.htm?title=${story.title}">Edit</a>
                        <a class="btn btn-danger" href="/delete_story.htm?title=${story.title}">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>

    <a class="btn btn-default" href="/newstory.htm">Write new story</a>
</div>
</body>
</html>