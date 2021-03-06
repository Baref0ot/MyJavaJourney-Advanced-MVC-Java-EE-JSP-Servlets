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
        <title>ConfidentU | Login</title>
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
            <h1>ConfidentU</h1>      
        </header>
        <main>
            <%
                HttpSession ses1;
                ses1 = request.getSession();
                Dentist d1 = (Dentist) ses1.getAttribute("d1Create");
            %> 
            <div class="verticallyCenter_mainContent">
            <h2>Congratulations <%=d1.getFirstName()%>, your account has been created!</h2>
            <img src="Pictures/LoginConfidentSmile.jpg" alt="A beautiful young burnette woman's healthy, white, straight, and confident smile."/>
            <form method="post" action="http://localhost:8080/ConfidentU_DentistProject/DentistLoginServlet">
                <label>Username: </label>
                <input type="text" name="dUserName" tabindex="1" required="required" placeholder=" Username... "/>
                <br/>
                <label>Password: </label>
                <input type="password" name="dPassword" tabindex="2" required="required" placeholder=" Password... "/>
                <br/>
                <input type="submit" name="loginBtn" tabindex="3" value="Enter" class="submitBtn" title="Login"/>
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
