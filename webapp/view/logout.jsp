<%@ page import="com.epam.constants.jsp_url.JspUrl" %><%
    session.invalidate();
    response.sendRedirect(JspUrl.LOGIN);
%>