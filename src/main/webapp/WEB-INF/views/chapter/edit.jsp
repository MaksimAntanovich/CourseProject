<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.10.3
  Time: 19.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="../static/header.jsp"/>
<h2>Sign up</h2>
<form:form action="/add_chapter.htm" modelAttribute="chapter" >
    <form>
        <input name="title" type="text" placeholder="Title?" />
        <textarea name="text" data-provide="markdown" rows="10"></textarea>
    </form>
    <input type="submit" value="Submit" class="btn btn-default"/>
</form:form>
</div>
</body>
</html>
