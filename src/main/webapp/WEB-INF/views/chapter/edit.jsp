<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.10.3
  Time: 19.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit Chapter</title>
</head>
<body>
<jsp:include page="../static/header.jsp"/>
<form:form action="/add_chapter.htm" modelAttribute="chapter" method='POST' role="form">
    <form:label path="title">Title</form:label>
    <form:input name="title" id="title" path="title" type="text" placeholder="Title?" />
    <form:textarea name="text" id="text" path="text" data-provide="markdown" data-width="400" rows="10" />
    <input type="submit" value="Submit" class="btn btn-default"/>
</form:form>
</div>
</body>
</html>
