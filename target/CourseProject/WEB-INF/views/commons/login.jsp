<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.9.22
  Time: 18.57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        #login-box{margin-right: auto; margin-left: auto; max-width: 200px}
    </style>
    <title>Starter Template for Bootstrap</title>
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
        <div class="form-group">
            <label for="login">Login</label>
            <form:input path="login" id="login" cssClass="form-control"></form:input>
            <form:errors path="login" cssclass="error"></form:errors>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <form:password path="password" id="password" cssClass="form-control"></form:password>
            <form:errors path="password" cssclass="error"></form:errors>
        </div>
        <input name="submit" type="submit" value="submit" class="btn btn-default"/>
    </form>
</div>

</body>
</html>