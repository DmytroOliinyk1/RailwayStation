<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.dto.UserDto" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 28.04.2020
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<%--"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
<body>
<%
    UserDto currentUser = (UserDto) session.getAttribute("currentUser");
    if(currentUser == null){
        response.sendRedirect("/view/login.jsp ");
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
            <th>Departure date</th>
            <th>Wagon number</th>
            <th>Place number</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${historyList}" var="history">
            <tr>
                <td>${history.trainNumber}</td>
                <td>${history.fromStation}</td>
                <td>${history.toStation}</td>
                <td>${history.departureTime}</td>
                <td>${history.arrivalTime}</td>
                <td>${history.departureDate}</td>
                <td>${history.wagonNumber}</td>
                <td>${history.placeNumber}</td>
                <td>${history.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>
<script>
    $(document).ready(function(){
        $("#datatable").DataTable();
    })
</script>

</body>
</html>


