<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.9.22
  Time: 18.57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        #login-box{margin-right: auto; margin-left: auto; max-width: 200px}
    </style>
</head>
<body onload='document.loginForm.username.focus();'>
<jsp:include page="../static/header.jsp"/>
<div id="login-box">
    <h2>Sign in</h2>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
    <form name='loginForm'
          action="<c:url value='/j_spring_security_check' />" method='POST' role="form">
        <label for="login">Login</label>
        <input  type='text' name='login' id="login" class="form-control" />
        <label for="password">Password</label>
        <input  type='password' name='password' id="password" class="form-control"/>
        <input name="submit" type="submit" value="submit" class="btn btn-default"/>
    </form>
</div>
</body>
</html>