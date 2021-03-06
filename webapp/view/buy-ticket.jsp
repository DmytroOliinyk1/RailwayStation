<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.dto.UserDto" %>
<%@ page import="com.epam.constants.jsp_url.JspUrl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy ticket</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>
<%
    UserDto currentUser = (UserDto) session.getAttribute("currentUser");
    if(currentUser == null){
        response.sendRedirect(JspUrl.LOGIN);
    }
%>
<div class = "container">

    <p class="text-danger">${message}</p>

    <table border="1" class="table table-light table-hover" id="datatable">
        <thead>
        <tr class="thead-dark">
            <th>Train №</th>
            <th>From station</th>
            <th>To station</th>
            <th>Departure time</th>
            <th>Arrival time</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${currentTrain.trainNumber}</td>
            <td>${currentTrain.fromStation}</td>
            <td>${currentTrain.toStation}</td>
            <td>${currentTrain.departureTime}</td>
            <td>${currentTrain.arrivalTime}</td>
            <td>${currentTrain.price}</td>
        </tr>
        </tbody>
    </table>
    <div>
        <p>
            <label class="text-muted">*Number of wagons: ${currentTrain.wagonsQuantity}</label>
        </p>
        <p>
            <label class="text-muted">*Number of places: ${currentTrain.placesQuantity}</label>
        </p>
    </div>


    <form action=${pageContext.request.contextPath}/buy-ticket method="post">
        <div class="card">

            <div class="card-body">

                <div class="form-group">
                    <label>Your name</label>
                    <input type="text" class="form-control" name="name" value="${currentUser.name}"placeholder="name"
                           readonly/>


                </div>

                <div class="form-group">
                    <label>Your surname</label>
                    <input type="text" class="form-control" name="surname" value="${currentUser.surname}" placeholder="surname"
                           readonly/>
                </div>

                <div class="form-group">
                    <label>Enter departure date:</label>
                    <input type="date" class="form-control form-control" name="departureDate"
                           min="${currentDate}" max="${currentDatePlusMonth}"/>
                </div>

                <div class="form-group">
                    <label>Enter wagon</label>
                    <input type="number" class="form-control" name="wagonNumber"  placeholder="wagon"
                           min="1" max="${currentTrain.wagonsQuantity}"/>
                </div>

                <div class="form-group">
                    <label>Enter place</label>
                    <input type="number" class="form-control" name="placeNumber"  placeholder="place"
                           min="1" max="${currentTrain.placesQuantity}"/>
                </div>

            </div>

            <div class="card-footer">
                <input type="submit" value="Buy" class="btn btn-primary"/>
            </div>

        </div>
    </form>
</div>
</body>
</html>