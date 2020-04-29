<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change password</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>

<div class="container">

    <form action=${pageContext.request.contextPath}/change-password method="post">
        <div class="card">

            <div class="card-header">
                Change password
            </div>

            <div class="card-body">

                <div class="form-group">
                    <input type="text" class="form-control" name="email" value="${currentUser.email}" placeholder="email"/>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" name="newPassword" placeholder="new password"/>
                </div>

            </div>

            <div class="card-footer">
                <input type="submit" value="Change" class="btn btn-primary"/>
            </div>

        </div>
    </form>
</div>
</body>
</html>
