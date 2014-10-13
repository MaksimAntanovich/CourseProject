<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.9.30
  Time: 15.15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstrap/css/starter-template.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">


    <link href="bootstrap/css/star-rating.min.css" media="all" rel="stylesheet" type="text/css" />
    <script src="bootstrap/js/star-rating.min.js" type="text/javascript"></script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap-markdown.js"></script>
    <script src="bootstrap/js/markdown.js"></script>
    <script src="bootstrap/js/to-markdown.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Writers Community</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-left" >
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/newstory.htm">Write new Story</a></li>
                </sec:authorize>>
            </ul>
            <ul class="nav navbar-nav navbar-right" >
                <sec:authorize access="isAnonymous()">
                    <li><a href="registration.htm">Sign Up</a></li>
                    <li><a href="login.htm">Login</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/cabinet.htm">Hello, ${user.login}</a></li>
                    <li><a href="j_spring_security_logout">Log Out</a></li>
                </sec:authorize>
                <sec:authorize access='hasRole("ADMIN")'>
                    <li><a href="/admin.htm">Admin Cabinet</a></li>
                </sec:authorize>>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

</body>
</html>
