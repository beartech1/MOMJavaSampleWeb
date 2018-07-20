<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Resume</title>
</head>
<body>
    <h1>Resume Summary Topics</h1>
    <c:forEach items="${topics}" var="topic">
        ${topic}<br />
    </c:forEach>
    <br />
    <h3>Resume Text</h3>
    <c:forEach items="${lines}" var="line">
        ${line}<br />
    </c:forEach>
    <br />
    <h1>All Done!</h1>
</body>
</html>
