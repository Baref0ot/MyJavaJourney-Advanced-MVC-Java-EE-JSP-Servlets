<%-- 
    Document   : DisplayAccounts
    Created on : Oct 18, 2018, 4:46:48 PM
    Author     : Mattw
--%>
<%@page import=" static java.lang.System.out"%>
<%@page import="Business.CustBusObj"%>
<%@page import="Business.AccountList"%>
<%@page import="Business.AccountBusObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title> MattsBank | Accounts </title>
            <meta name="author" content="Matthew Lee Wright"/>
            <meta name="description" content="This is a Matt's Bank index welcome page."/>
            <meta name="keywords" content="Chattahoochee, Technical, college, Bank, Welcome"/>
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <link href="MattsBankCSS.css" rel="stylesheet"/>
            <script type="text/javascript">
            </script>
            <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
            </script>
            <![endif]-->
    </head>
    <body>
        <!-- get the customer object out of the session to display the customers accounts -->
        <%
            // Below is an alternate way of getting objects out of the session using java
            HttpSession ses1 = request.getSession();
            CustBusObj c1 = (CustBusObj)ses1.getAttribute("c1Name"); 
            c1.display();
        %>
        
        <table id="accountsDisplay">
            <caption>Here's your Account Information <%=c1.getCustFirstName()%>:</caption>
             <tr>
                 <td><%=c1.getCustFirstName()%></td>
             </tr>
             <tr>
                 <td><%=c1.getCustLastName()%></td>
             </tr>
             <tr>
                 <td><%=c1.getCustEmail()%></td>
             </tr>
             <tr></tr>
        </table>
           
    <p><b><%=c1.getCustFirstName()%>'s Accounts:</b></p>
         <%
           AccountBusObj a2 = null;
           for(int x = 0; x < c1.alist.count; x++){
              a2 = c1.alist.aArry[x];
           
         %>
         <table id="accountsDisplay">
             <tr>
                 <th>Account Number:</th>
                 <th>Customer Id:</th>
                 <th>Account Type:</th>
                 <th>Account Balance:</th>
             </tr>
             <tr>
                 <td><%=a2.getAcctNo()%></td>
                 <td><%=a2.getCustId()%></td>
                 <td><%=a2.getAcctType()%></td>
                 <td><%=a2.getBalance()%></td>
             </tr>
         </table>
        <%
            }// end for
        %>
        
    </body>
</html>
