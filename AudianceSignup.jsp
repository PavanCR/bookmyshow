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

		<form action="audianceSignup" method="post">
			First Name <input type="text" name="fname"
				placeholder="Enter Your First Name" required><br>
			<br> Last Name <input type="text" name="name"
				placeholder="Enter Your Last Name" ><br>
			<br> Phone Number <input type="number" name="PhNumber"
				placeholder="Enter Your Number" required><br>
			<br> User Name <input type="email" name="email"
				placeholder="Enter User Id" required><br>
			<br> PassWord <input type="password" name="password"
				placeholder="Enter PassWord" required><br>
			<br>
			<button>SignUp</button>
			<button type="reset">Cancel</button>
		</form>
		<a href="AudianceLogin.jsp">
			<p>Already Have Account?</p>
		</a>
	</center>
</body>
</html>