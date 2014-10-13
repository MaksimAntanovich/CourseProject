<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.9.30
  Time: 15.23
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <title>Writers Community</title>
    <script type="text/javascript">
        $(document).ready(function () {$("#input-id").rating()});
    </script>
</head>

<body>
<jsp:include page="../static/header.jsp"/>
<div class="container">

    <div class="starter-template">
        <h1>Welcome to Writers Community.</h1>
        <p class="lead">Write and share your creative stories</p>


</div><!-- /.container -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Author</th>
            <th>Story Title</th>
            <th>Actions</th>
            <sec:authorize access="isAuthenticated()">
                <th>Rating</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stories}" var="story">
            <tr>
                <td>${story.author.login}</td>
                <td>${story.title}</td>
                <td>
                    <div class="btn-group">
                        <a class="btn btn-info" href="/read.htm?title=${story.title}&id=1">Read</a>
                        <sec:authorize access="isAuthenticated()">
                            <a class="btn btn-warning" href="/annotate.htm?title=${story.title}">Annotate</a>
                        </sec:authorize>
                    </div>
                </td>
                <sec:authorize access="isAuthenticated()">
                    <td>
                        <input id="input-id" type="number" class="rating" min=1 max=10 step=2 data-size="lg" data-rtl="true">
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>