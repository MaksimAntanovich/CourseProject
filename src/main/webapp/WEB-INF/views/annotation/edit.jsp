<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.10.13
  Time: 14.39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>View Annotation</title>
</head>
<body>
<h3>Annotation</h3>
<jsp:include page="../static/header.jsp"/>
<form:form action="/add_annotation.htm" modelAttribute="annotation" method='POST' role="form">
    <form:textarea name="text" id="text" path="text" data-width="400" rows="10" /><br>
    <input type="submit" value="Submit" class="btn btn-default"/>
</form:form>

</body>
</html>
