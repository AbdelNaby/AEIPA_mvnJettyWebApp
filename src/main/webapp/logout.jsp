<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body bgcolor="#669900">
    <%
session.setAttribute("username", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>
</body>
</html>