<%
    session.invalidate();
    response.sendRedirect("/view/login.jsp");
%>