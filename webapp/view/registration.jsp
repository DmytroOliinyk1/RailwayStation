<%@ page import="com.epam.dto.UserDto" %>
<%@ page import="com.epam.constants.jsp_url.JspUrl" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 25.04.2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>

<%
    UserDto currentUser = (UserDto) session.getAttribute("currentUser");
    if(currentUser != null){
        response.sendRedirect(JspUrl.SEARCH_TRAINS);
    }


%>


<div class="container">
    <form action=${pageContext.request.contextPath}/registration method="post">
        <div class="card">

            <div class="card-header">
                Registration
            </div>

            <div class="card-body">

                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name"/>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" name="surname" placeholder="Surname"/>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="example@email.com"/>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="password"/>
                </div>

            </div>

            <div class="card-footer">
                <input type="submit" value="Login" class="btn btn-primary"/>
            </div>

        </div>
    </form>
</div>
</body>
</html>