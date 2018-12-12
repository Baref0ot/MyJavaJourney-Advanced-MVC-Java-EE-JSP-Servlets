<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
    Name: Matthew Lee Wright
    Class: Java 3
    Date: 5 November 2018
-->
<html lang="en">
    <head>
        <title>ConfidentU | Dentist Create</title>
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
            <h1>ConfidentU</h1>      
        </header>
        <main>
            <div class="verticallyCenter_mainContent">
                <h2>You are creating a Dentist Account.</h2>
            <form method="post" action="http://localhost:8080/ConfidentU_DentistProject/CreateDentistServlet">
                <label>Username:</label>
                <input type="text" name="userName" tabindex="1" required="required" placeholder=" Enter a Username... "/>
                <br/>
                <label>Password:</label>
                <input type="password" name="password" tabindex="2" required="required" placeholder=" Enter a Password... "/>
                <br/>
                <label>First Name:</label>
                <input type="text" name="firstName" tabindex="3" required="required" placeholder=" First Name... "/>
                <br/>
                <label>Last Name:</label>
                <input type="text" name="lastName" tabindex="4" required="required" placeholder=" Last Name... "/>
                <br/>
                <label>Email:</label>
                <input type="text" name="email" tabindex="5" required="required" placeholder=" Email... "/>
                <br/>
                <label>Office:</label>
                <input type="text" name="office" tabindex="6" required="required" placeholder=" Enter your office Number..."/>
                <br/>
                <input type="submit" name="loginBtn" tabindex="7" value="Sign Up" class="submitBtn" title="Sign Up"/>
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
