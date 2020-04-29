<%@ page import="com.epam.entity.User" %>
<%@ page import="com.epam.dto.UserDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>

<%
    UserDto currentUser = (UserDto) session.getAttribute("currentUser");
    if(currentUser != null){
        response.sendRedirect("/view/search-trains.jsp");
    }


%>


<div class="container">
    <p class="text-success">${successMessage}</p>
    <p class="text-danger">${failedMessage}</p>
    <form action=${pageContext.request.contextPath}/login method="post">
        <div class="card">

            <div class="card-header">
                Login
            </div>

            <div class="card-body">

                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="email"/>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="password"/>
                </div>
                <div class="float-right">
                    <a href="${pageContext.request.contextPath}/view/change-password.jsp">Forgot password?</a>
                </div>
                <div class="float-left">
                    <a href="${pageContext.request.contextPath}/view/registration.jsp">Registration</a>
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
