<%-- 
    Document   : DisplayAccount
    Created on : Oct 15, 2018, 3:05:10 PM
    Author     : Matthew Wright
    Lab # 6
--%>

<%@page import="Business.AccountBusObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title> MattsBank | Look Up </title>
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
        <header>
            <a href="Index.jsp" title="Click to go to the Home page"><h1>Welcome to Matt's Bank</h1></a>
        </header>
        <main>
            <!-- Get the account object, named "a1ObjName", out of the session that was passed up by AccountLookUpServlet.java -->
            <%
                HttpSession ses1;
                ses1 = request.getSession();
                AccountBusObj a1 = (AccountBusObj) ses1.getAttribute("a1ObjName");
            %>            
            <form method="post" class="lookUpPosition" action="http://localhost:8080/MattsBank/AccountLookUpServlet">
                <h3> Account Look Up: </h3>
                <div class="formCenter">
                    <table>
                        <tr>
                            <td>Account Number:</td>
                            <td><input type="text" name="acctNo" placeholder="1111-2222-3333-4444..." value="<%=a1.getAcctNo()%>" title="Typer your account number" class="lookUpIn"/></td>
                        </tr>
                        <tr>
                            <td>Customer ID:</td>
                            <td><input type="text" name="customerId" placeholder="12345..." value="<%=a1.getCustId()%>" title="Type your customer id" class="lookUpIn"/></td>
                        </tr>
                        <tr>
                            <td>Account Type:</td> 
                            <td><input type="text" name="type" placeholder="Savings..." value="<%=a1.getAcctType()%>" title="Enter the type of account" class="lookUpIn"/></td>
                        </tr>
                        <tr>
                            <td>Balance:</td> 
                            <td><input type="text" name="balance" placeholder="$128,000.00" value="<%=a1.getBalance()%>" title="Type your balance" class="lookUpIn"/></td>
                        </tr>
                    </table>
                </div>
                <div class="acntBtnPos">
                    <input type="submit" name="lookUpBtn" value="Look Up" class="acntLookUpBtn" title="Look up an account"/>
                    <button type="reset" name="clearBtn" value="Clear" class="acntLookUpBtn" title="Clear results">Clear</button>
                </div>
            </form>
        </main>
        <footer>
        </footer>
        <!-- The script tags usually go in the <head> tag, but the BEST place to put JavaScript Source file is at the end of the <body> so that the user can see the webpage while the JS code is loading -->
        <script type="text/javascript" src="">
        </script>
    </body>
</html>

