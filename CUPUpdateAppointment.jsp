<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
    Name: Matthew Lee Wright
    Class: Java 3
    Date: 5 November 2018
-->
<html lang="en">
    <head>
        <title>ConfidentU | Patient Update Appointment</title>
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
                <li><a href="../CUPAccountInfo.jsp" title="View or Update your account information">My Account</a></li>
                <li><a href="./CUPAddAppointment.jsp" title="Schedule an appointment">Schedule Appointment</a></li>
                <li><a class="active" href="../CUPAppointmentInfo.jsp" title="View or Update or appointments">View Appointments</a></li>
            </ul>
        </nav>
        <main>
            <!-- Get the Patient, Procedure, Dentist, and Appointment Object out of the session that was passed in from ScheduleAppointmentServlet.java -->
            <%
                HttpSession ses1;
                ses1 = request.getSession();
                Patient p1 = (Patient) ses1.getAttribute("p1LoginSession");
            %>  
            <%
                HttpSession ses2;
                ses2 = request.getSession();
                Appointment a1 = (Appointment) ses2.getAttribute("p1AppointmentInfo");
            %>
            <%
                HttpSession ses3;
                ses3 = request.getSession();
                Procedure pr1 = (Procedure) ses3.getAttribute("p1ProcedureInfo");
            %>
            <%
                HttpSession ses4;
                ses4 = request.getSession();
                Dentist d1 = (Dentist) ses4.getAttribute("p1DentistInfo");
            %>
            <%
                HttpSession ses5;
                ses5 = request.getSession();
                Procedure pr2 = (Procedure) ses5.getAttribute("pr2SetApp");
            %> 
            <%
                HttpSession ses6;
                ses6 = request.getSession();
                 Dentist d2 = ( Dentist) ses6.getAttribute("d1SetApp");
            %> 
            <%
                HttpSession ses7;
                ses7 = request.getSession();
                Appointment a2 = (Appointment) ses7.getAttribute("a2SetApp");
            %>  
            <div class="verticallyCenter_mainContent">
                <h2>Let's Update your Appointment.</h2>
            <form method="post" action="http://localhost:8080/ConfidentU_DentistProject/UpdateAppointmentServlet">
                <label>Date and Time:</label>
                <input type="text" name="apptDateTime" tabindex="1" value="<%=a1.getApptDateTime()%>" placeholder="<%=a1.getApptDateTime()%>"/>
                <br/>
                <label>Purpose:</label>
                <input type="text" name="procedure" tabindex="2" value="<%=pr1.getProcCode()%>" placeholder="<%=pr1.getProcCode()%>"/>
                <br/>
                <label>Dentist:</label>
                <input type="text" name="dentist" tabindex="3" value="<%=d1.getDentistId()%>" placeholder="<%=d1.getDentistId()%>"/>
                <br/>
                <input type="submit" name="loginBtn" tabindex="4" value="Update" class="submitBtn"/>
                <br/>
                <br/>
                <div class="accountInfoUpdateBtns">
                    <a href="./CUPUpdateAppointment.jsp" title="Clear all Input">Clear</a>
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
