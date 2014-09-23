<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 14.9.22
  Time: 17.07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>sign up</title>
    <script type="javascript">
        function validateForm(){
            alert($('#password').text);
            if  ($('#password').text != $('#confirmPassword')){
                alert('false');
                return false;
            }
        }
    </script>
</head>
<body>
<div style="margin-left: auto; margin-right: auto; max-width: 200px">
    <h2>Sign up</h2>
    <form:form action="/add_user.htm" modelAttribute="user" onsubmit="return validateForm();">
        <label for="login">Login: </label>
        <form:input path="login" id="login" cssClass="form-control"></form:input>
        <form:errors path="login" cssclass="error"></form:errors>
        <br>
        <label for="email">E-mail: </label>
        <form:input path="email" id="email" cssClass="form-control"></form:input>
        <form:errors path="email" cssclass="error"></form:errors>
        <br>
        <label for="password">Password: </label>
        <form:password path="password" id="password" cssClass="form-control"></form:password>
        <form:errors path="password" cssclass="error"></form:errors>
        <br>
        <input type="submit" value="Submit" class="btn btn-default"/>
    </form:form>
</div>
<script type="javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.js"></script>
</body>
</html>