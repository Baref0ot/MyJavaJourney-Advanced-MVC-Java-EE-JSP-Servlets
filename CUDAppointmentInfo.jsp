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
        <title>ConfidentU | Dentist Appointment View</title>
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
                    <li><a href="../CUDAccountInfo.jsp" title="View or Update your account information">My Account</a></li>
                    <li><a class="active" href="CUDAppointmentInfo.jsp" title="View your list appointments">View Appointments</a></li>
                </ul>
            </nav>
        </div>
        <main>
            <h2>Here's a list of your Appointments.</h2>
            <!-- Get the Dentist object, named "d1LoginSession", out of the session that was passed up by DentistLoginServlet1.java -->
            <div class="HorizontalCenter_mainContent">
            <%
                HttpSession ses1;
                ses1 = request.getSession();
                Dentist d1 = (Dentist) ses1.getAttribute("d1LoginSession");
                d1.display();
            %>  
            <%
                Appointment a2 = null;
                for(int x = 0; x < d1.applist.count; x++){
                   a2 = d1.applist.appointmentsArray[x];              
            %>
                
                 <!--// old style class: class="verticallyCenter_mainContent"-->
                    <table class="tableDesign">
                        <tr>
                           <td>Dentist Id:</td> <td><%=d1.getDentistId()%></td>
                        </tr>
                        <tr>
                           <td>Dentist Name:</td> <td><%=d1.getFirstName()%> <%=d1.getLastName()%></td>
                        </tr>
                        <tr>
                            <td>Patient Id:</td> <td><%=a2.getPatientId()%></td>
                        </tr>
                        <tr>
                           <td>Purpose:</td> <td><%=a2.getProcCode()%></td>
                        </tr>
                        <tr>
                            <td>Date and Time:</td> <td><%=a2.getApptDateTime()%></td>
                        </tr>
                    </table>                
            <%
                }// end for()
            %>
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
