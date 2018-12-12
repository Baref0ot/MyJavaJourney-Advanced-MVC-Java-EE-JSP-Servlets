<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
    Name: Matthew Lee Wright
    Class: Java 3
    Date: 3 December 2018
-->
<html lang="en">
    <head>
        <title>ConfidentU | Patient Appointment View</title>
        <meta name="author" content="Matthew Lee Wright"/>
        <meta name="description" content="This is a application for the dentist office ConfidentU where patients needing oral health care can recieve great oral care by well trained qualified professionals with years of expert experience. This application will allow both patients and dentist to log in create and see their appointment schedule."/>
        <meta name="keywords" content=" Oral health, oral, health, gum, gums, teeth, tough, clean, wisdom teeth removal, wisdom, teeth, removal, gingivitis, cleaning, whitening, best, affordable dental care, affordable, dental, care, cheap, my, hurt, teeth remedy"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="./ConfidentUStyle.css" rel="stylesheet"/>
        <script type="text/javascript">
        </script>
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
        </script>
        <![endif]-->
    </head>
    <body>
        <header>
            <h1><a href="./CUPAccountInfo.jsp" title="Go to the Home Page">ConfidentU</a></h1>  
        </header>
        <nav>
            <ul>
                <li><a href="./CUPAccountInfo.jsp" title="View or Update your account information">My Account</a></li>
                <li><a href="patients/CUPAddAppointment.jsp" title="Schedule an appointment">Schedule Appointment</a></li>
                <li><a class="active" href="patients/CUPAppointmentInfo.jsp" title="View or Update or appointments">View Appointments</a></li>
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
                HttpSession ses8;
                ses8 = request.getSession();
                Procedure pr1 = (Procedure) ses8.getAttribute("p1ProcedureInfo");
            %> 
            <%
                HttpSession ses9;
                ses9 = request.getSession();
                Dentist d1 = (Dentist) ses9.getAttribute("p1DentistInfo");
            %> 
            <%
                HttpSession ses10;
                ses10 = request.getSession();
                Appointment a1 = (Appointment) ses10.getAttribute("p1AppointmentInfo");
            %>  
            <div class="verticallyCenter_mainContent">
                <h2>Your Appointment has been updated.</h2>
                <table class="tableDesign">
                    <tr>
                        <td>Date and Time:</td> <td><%=a1.getApptDateTime()%></td>
                    </tr>
                    <tr>
                        <td>Patient Id:</td> <td><%=p1.getPatientId()%></td>
                    </tr>
                    <tr>
                        <td>Patient Name:</td> <td><%=p1.getFirstName()%> <%=p1.getLastName()%></td>
                    </tr>
                    <tr>
                       <td>Purpose:</td> <td><%=pr1.getProcName()%></td>
                    </tr>
                    <tr>
                       <td>Dentist:</td> <td><%=d1.getFirstName()%> <%=d1.getLastName()%></td>
                    </tr>
                    <tr>
                       <td>provider:</td> <td><%=p1.getInsuranceCo()%></td>
                    </tr>
                </table>
                
            <form method="post" action="">
                <br/>
                <br/>
                <div class="accountInfoUpdateBtns">
                    <a href="patients/CUPUpdateAppointment.jsp" title="Update your scheduled Appointment">Update</a>
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
