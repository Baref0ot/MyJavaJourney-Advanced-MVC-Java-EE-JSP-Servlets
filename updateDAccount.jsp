<%@page import="Business.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
    Name: Matthew Lee Wright
    Class: Java 3
    Date: 5 November 2018
-->
<html lang="en">
    <head>
        <title>ConfidentU | Dentist Account Update</title>
        <meta name="author" content="Matthew Lee Wright"/>
        <meta name="description" content="This is a application for the dentist office ConfidentU where patients needing oral health care can recieve great oral care by well trained qualified professionals with years of expert experience. This application will allow both patients and dentist to log in create and see their appointment schedule."/>
        <meta name="keywords" content=" Oral health, oral, health, gum, gums, teeth, tough, clean, wisdom teeth removal, wisdom, teeth, removal, gingivitis, cleaning, whitening, best, affordable dental care, affordable, dental, care, cheap, my, hurt, teeth remedy"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="../ConfidentUStyle.css" rel="stylesheet"/>
        <script type="text/javascript">
        </script>
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
        </script>
        <![endif]-->
    </head>
    <body>
        <header>
            <h1><a href="../CUDAccountInfo.jsp" title="Go to the Home Page">ConfidentU</a></h1>       
        </header>
        <div class="dentistNav">
            <nav>
                <ul>
                    <li><a class="active" href="../CUDAccountInfo.jsp" title="View or Update your account information">My Account</a></li>
                    <li><a href="./CUDAppointmentInfo.jsp" title="View your list appointments">View Appointments</a></li>
                </ul>
            </nav>
        </div>
        <main>
            <!-- Get the Dentist object, named "d1LoginSession", out of the session that was passed up by DentistLoginServlet1.java -->
            <%
                HttpSession ses1;
                ses1 = request.getSession();
                Dentist d1 = (Dentist) ses1.getAttribute("d1LoginSession");
            %>       
            <div class="verticallyCenter_mainContent">
                <h2>Lets update your account.</h2>
            <form method="post" action="http://localhost:8080/ConfidentU_DentistProject/DentistUpdateServlet">
                <label>First Name:</label>
                <input type="text" name="firstName" value="<%=d1.getFirstName()%>" tabindex="1" placeholder="<%=d1.getFirstName()%>"/>
                <br/>
                <label>Last Name:</label>
                <input type="text" name="lastName" value="<%=d1.getLastName()%>" tabindex="2" placeholder="<%=d1.getLastName()%>"/>
                <br/>
                <label> Email:</label>
                <input type="text" name="email" value="<%=d1.getEmail()%>" tabindex="3" placeholder="<%=d1.getEmail()%>"/>
                <br/>
                <label>Office #:</label>
                <input type="text" name="officeNumber" value="<%=d1.getOfficeNo()%>" tabindex="4" placeholder="<%=d1.getOfficeNo()%>"/>
                <br/>
                <input type="submit" name="loginBtn" tabindex="5" value="Update" class="submitBtn"/>
                <br/>
                <br/>
                <div class="accountInfoUpdateBtns">
                    <a href="./updateDAccount.jsp" title="Clear all Input">Clear</a>
                </div>
            </form>
            </div>
        </main>
        <footer>
            <p> Copyright &copy; ConfidentU 2018 </p>
        </footer>
        <!-- The script tags usually go in the <head> tag, but the BEST place to put JavaScript Source file is at the end of the <body> so that the user can see the web page while the JavaScript code is loading -->
        <script type="text/javascript" src="">
        </script>
    </body>
</html>
