<%@ page import="com.epam.dto.UserDto" %>
<%@ page import="com.epam.constants.jsp_url.JspUrl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
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
    <p class="text-muted">${message}</p>
    <form action=${pageContext.request.contextPath}/search-trains method="post">

        <div class="card">

            <div class="card-header">
                Search
                <div class="float-right">
                    <a href="${pageContext.request.contextPath}/view/manage-account.jsp">Manage account</a>
                </div>
            </div>


            <div class="card-body">

                <div class="form-group">
                    <label>from</label>
                    <input type="text" class="form-control" name="fromStation"/>
                </div>

                <div class="form-group">
                    <label>to</label>
                    <input type="text" class="form-control" name="toStation"/>
                </div>

            </div>

            <div class="card-footer">
                <input type="submit" value="Search" class="btn btn-primary"/>
                <div class="float-right">
                    <a href="${pageContext.request.contextPath}/get-history">Go to history</a>
                </div>
            </div>

        </div>
    </form>

</div>
</body>
</html>