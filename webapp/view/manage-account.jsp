<%@ page import="com.epam.dto.UserDto" %>
<%@ page import="com.epam.constants.jsp_url.JspUrl" %>

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
        response.sendRedirect(JspUrl.LOGIN);
    }
%>
<div class="float-left">
    <a href="${pageContext.request.contextPath}/view/change-password.jsp">Change password</a>
</div>
<div class="float-left">
    <a href="${pageContext.request.contextPath}/view/delete-account.jsp">Delete account</a>
</div>
<div class="float-left">
    <a href="${pageContext.request.contextPath}/view/logout.jsp">Logout</a>
</div>
</body>
</html>
