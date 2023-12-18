<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="producerSignup" method="post">
			Producer Name<input type="text" name="producername"
				placeholder="Enter Your name" required><br>
			<br> User Name<input type="text" name="username"
				placeholder="Enter User Name" required> <br>
			<br> Password<input type="password" name="password"
				placeholder="Enter Password" required><br>
			<br> Enter Movie Title<input type="text" name="title"
				placeholder="Enter Movie Title" required><br>
			<br>

			<button>Register</button>
			<button type="reset">Cancel</button>
		</form>
<a href="ProducerLogin.jsp"> <p>Already Have Account?</p> </a>
	</center>
</body>
</html>