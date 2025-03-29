<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="container">
    <%
        // Quick redirect approach
        response.sendRedirect(request.getContextPath() + "/Bienvenue");
    %>
</div>
</body>
</html>
