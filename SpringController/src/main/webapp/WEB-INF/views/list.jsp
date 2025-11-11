<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 11/6/2025
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Students</h1>
<c:forEach var="item" items="${students}">
    <h3>Name: ${item.name} - Age: ${item.age}</h3>
</c:forEach>
<%-- View engine: JSTL (JSP) => ThymeLeaf (HTML) --%>
</body>
</html>
