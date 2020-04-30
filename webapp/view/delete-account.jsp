<%@ page import="com.epam.dto.UserDto" %>
<%@ page import="com.epam.constants.jsp_url.JspUrl" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 30.04.2020
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete account</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>

<%
    UserDto currentUser = (UserDto) session.getAttribute("currentUser");
    if(currentUser == null){
        response.sendRedirect(JspUrl.LOGIN);
    }


%>


<div class="container">

    <form action=${pageContext.request.contextPath}/delete-history method="post">
        <div class="card">

            <div>
                Are you sure? All your tickets and history will be deleted.
            </div>

            <div class="card-footer">
                <input type="submit" value="Delete" class="btn btn-primary"/>
            </div>

        </div>
    </form>
</div>
</body>
</html>
