<%--
  Created by IntelliJ IDEA.
  User: sheetal
  Date: 17/04/20
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
<h1>Hi <%= session.getAttribute("username") %>, Registration Successful</h1>
<a href="login.html">Login Page</a>
</body>
</html>
