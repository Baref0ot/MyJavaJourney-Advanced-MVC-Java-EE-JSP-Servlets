<%-- 
    Document   : ErrorPage
    Created on : Oct 8, 2018, 3:43:44 PM
    Author     : Matthew Wright
    Lab # 6
--%>

<%@page import="Business.CustBusObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
    </head>
    <body>
        <!-- Get c1Name Object from the session -->
        <% HttpSession ses1;
           ses1 = request.getSession();
           CustBusObj c1 = (CustBusObj)ses1.getAttribute("c1Name"); 
        %>
        <h1>Sorry <%=c1.getCustFirstName()%> the Username or password you entered is incorrect.</h1>
        <a href="Login.jsp" title="Try Again">Try Again</a>
    </body>
</html>
