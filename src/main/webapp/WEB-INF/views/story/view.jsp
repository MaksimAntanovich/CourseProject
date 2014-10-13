<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.10.7
  Time: 18.47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit Story</title>
</head>
<body>
<jsp:include page="../static/header.jsp"/>
<div class="container" align="center">
<div class="form-group">
<form:form action="/add_story.htm" modelAttribute="story" method='POST' role="form">
    <label for="title" class="col-md-4 control-label">Story Title</label>
    <div class="col-md-4">
        <form:input name="title" id = "title" path="title" type="text" placeholder="Story Title" />
    <input type="submit" value="Change" class="btn btn-default"/>
    </div>
</form:form>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Chapter Title</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${story.chapters}" var="chapter">
        <tr>
        <td>${chapter.title}</td>
        <td>
        <div class="btn-group">
            <a class="btn btn-primary" href="/chapter.htm?title=${chapter.title}">Edit</a>
            <a class="btn btn-danger" href="/delete_chapter.htm?title=${chapter.title}">Delete</a>
        </div>
        </td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
<a class="btn btn-default" href="/newchapter.htm?title=${story.title}">Add chapter</a><br>
</div>
</body>
</html>
