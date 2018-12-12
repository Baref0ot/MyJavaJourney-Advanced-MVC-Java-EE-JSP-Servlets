<!--

		Name:  Matthew Lee Wright
		Class: Java 3
		Date:  8/29/2018
		
-->
<!DOCTYPE html>
<html lang="en">
	<head>
		<title> ChattBank | Login </title>
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
                    <div class="indeximg">
                        <img src="MattsBankImg.jpg" class="idxImgProp" alt="A picture of Matts Bank that is displayed on the index page to welcome the user. The picture has a white background color and displays the text &amp; Connect With Us &amp;"/>
                    </div>
                    <form method="post" action="http://localhost:8080/MattsBank/LoginServlet" class="loginPostiton">
                        <input type="text" name="userName" placeholder="Username..." class="loginIn"/>
                        <input type="password" name="password" placeholder="Password..." class="loginIn"/>
                        <input type="submit" name="loginBtn" value="Login" class="acntLoginBtn"/>
                    </form>
		</main>
		<footer>
		</footer>
		<!-- The script tags usually go in the <head> tag, but the BEST place to put JavaScript Source file is at the end of the <body> so that the user can see the webpage while the JS code is loading -->
		<script type="text/javascript" src="">
		</script>
	</body>
</html>
