<!--

		Name:  Matthew Lee Wright
		Class: Java 3
		Date:  8/29/2018
		
-->
<!DOCTYPE html>
<html lang="en">
	<head>
		<title> MattsBank | Welcome </title>
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
                    <h1> Welcome to Matt's Bank </h1>
		</header>
		<main>
                    <div class="indeximg">
                        <img src="MattsBankImg.jpg" class="idxImgProp" alt="A picture of Matts Bank that is displayed on the index page to welcome the user. The picture has a white background color and displays the text &amp; Connect With Us &amp;"/>
                    </div>
                    <form method="post" class="indexPosition">
                        <a href="Login.jsp"><input type="button" title="Log into your account" name="loginBtn" value="login" class="indexIn"/></a>
			<a href="AccountLookUp.jsp"><input type="button" title="Look up an account" name="acntLUBtn" value="Look Up" class="indexIn"/></a>
                        <input type="button" title="Create an account" name="signupBtn" value="sign up" class="indexIn"/>
                    </form>
		</main>
		<footer>
		</footer>
		<!-- The script tags usually go in the <head> tag, but the BEST place to put JavaScript Source file is at the end of the <body> so that the user can see the webpage while the JS code is loading -->
		<script type="text/javascript" src="">
		</script>
	</body>
</html>
