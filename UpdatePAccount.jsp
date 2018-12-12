<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
    Name: Matthew Lee Wright
    Class: Java 3
    Date: 5 November 2018
-->
<html lang="en">
    <head>
        <title>ConfidentU | Patient Account Update</title>
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
            <h1><a href="../CUPAccountInfo.jsp" title="Go to the Home Page">ConfidentU</a></h1>       
        </header>
        <nav>
            <ul>
                <li><a class="active" href="../CUPAccountInfo.jsp" title="View or Update your account information">My Account</a></li>
                <li><a href="./CUPAddAppointment.jsp" title="Schedule an appointment">Schedule Appointment</a></li>
                <li><a href="./CUPAppointmentInfo.jsp" title="View or Update or appointments">View Appointments</a></li>
            </ul>
        </nav>
        <main>
            <!-- Get the Patient object, named "p1LoginSession", out of the session that was passed up by PatientLoginServlet1.java -->
            <%
                HttpSession ses1;
                ses1 = request.getSession();
                Patient p1 = (Patient) ses1.getAttribute("p1LoginSession");
            %>            
            <div class="verticallyCenter_mainContent">
                <h2>Lets update your account.</h2>
            <form method="post" action="http://localhost:8080/ConfidentU_DentistProject/PatientUpdateServlet">
                <label>First Name:</label>
                <input type="text" name="firstName" tabindex="1" value="<%=p1.getFirstName()%>" placeholder="<%=p1.getFirstName()%>"/>
                <br/>
                <label>Last Name:</label>
                <input type="text" name="lastName" tabindex="2" value="<%=p1.getLastName()%>" placeholder="<%=p1.getLastName()%>"/>
                <br/>
                <label> Email:</label>
                <input type="text" name="email" tabindex="3" value="<%=p1.getEmail()%>" placeholder="<%=p1.getEmail()%>"/>
                <br/>
                <label>Address:</label>
                <input type="text" name="address" tabindex="4" value="<%=p1.getAddress()%>" placeholder="<%=p1.getAddress()%>"/>
                <br/>
                <label>Provider:</label>
                <input type="text" name="insuranceCo" tabindex="5" value="<%=p1.getInsuranceCo()%>" placeholder="<%=p1.getInsuranceCo()%>"/>
                <br/>
                <input type="submit" name="loginBtn" tabindex="3" value="Update" class="submitBtn"/>
                <br/>
                <br/>
                <div class="accountInfoUpdateBtns">
                    <a href="./UpdatePAccount.jsp" title="Clear all Input">Clear</a>
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