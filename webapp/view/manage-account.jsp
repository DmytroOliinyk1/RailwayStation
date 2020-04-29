<%@ page import="com.epam.dto.UserDto" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 25.04.2020
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <title>Manage account</title>--%>
    <title>Manage account</title>
</head>
<body>
<%
    UserDto currentUser = (UserDto) session.getAttribute("currentUser");
    if(currentUser == null){
        response.sendRedirect("/view/login.jsp ");
    }
%>
<div class="float-left">
    <a href="${pageContext.request.contextPath}/view/change-password.jsp">Change password</a>
</div>
<div class="float-left">
    <a href="${pageContext.request.contextPath}/delete-account">Delete account</a>
</div>
<div class="float-left">
    <a href="${pageContext.request.contextPath}/view/logout.jsp">Logout</a>
</div>
</body>
</html>
