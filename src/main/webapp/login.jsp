<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="auth" method="post">
    <input type="text" name="username" required>
    <input type="password" name="password" required>
    <button type="submit">Login</button>
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
<a href="register.jsp">Register</a>
</body>
</html>