<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 11/8/2025
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Form Create</h1>
<form action="/students/create" method="POST">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="age" placeholder="Age">
    <button>Submit</button>
</form>
</body>
</html>
