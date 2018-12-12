<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
    Name: Matthew Lee Wright
    Class: Java 3
    Date: 5 November 2018
-->
<html lang="en">
    <head>
        <title>ConfidentU | Patient Schedule Appointment</title>
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
                <li><a class="active" href="./CUPAddAppointment.jsp" title="Schedule an appointment">Schedule Appointment</a></li>
                <li><a href="../CUPAppointmentInfo.jsp" title="View or Update or appointments">View Appointments</a></li>
            </ul>
        </nav>
        <main>
            <div class="verticallyCenter_mainContent">
                <h2>Take the first step. Schedule an Appointment!</h2>
            <form method="post" action="http://localhost:8080/ConfidentU_DentistProject/ScheduleAppointmentServlet">
                <label>Date and Time:</label>
                <input type="text" name="apptDateTime" tabindex="1" placeholder=" May 1, 2018, 9am... "/>
                <br/>
                <label>Purpose:</label>
                <input type="text" name="procedure" tabindex="2" placeholder=" Whitening... "/>
                <br/>
                <label>Dentist:</label>
                <input type="text" name="dentist" tabindex="3" placeholder=" Susan Cassidy... "/>
                <br/>
                <input type="submit" name="loginBtn" tabindex="4" value="Schedule" class="submitBtn" title="Schedule"/>
                <br/>
                <br/>
                <div class="accountInfoUpdateBtns">
                    <a href="./CUPAddAppointment.jsp" title="Clear all Input">Clear</a>
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
