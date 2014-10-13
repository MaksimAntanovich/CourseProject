<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.10.13
  Time: 00.46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${story.title}</title>
</head>
<body>
<jsp:include page="../static/header.jsp"/>
<c:set var="count" scope="page" value="1"/>
<div data-provide="markdown-editable" id="editor">
${text}
</div>
<div class="btn-toolbar" role="toolbar">
    <tex class="btn-group">
    <c:forEach items="${story.chapters}" var="chapter">
        <a class="btn btn-default col-md-1" href="/read.htm?title=${story.title}&id=${count}">${count}</a>
        <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
    </div>
</div>
</body>
</html>
