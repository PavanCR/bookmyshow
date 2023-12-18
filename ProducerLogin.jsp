<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>${msg}</h1>
		<form action="producerlogin" method="post">
			User name <input type="text" name="username" placeholder="Enter User Name"><br>
			<br> Password <input type="password" name="password" placeholder="Enter Password"><br>
			<br>
			<button>Submit</button>
		</form>
		<a href="index.jsp"><button>Back</button></a> <a
			href="ProducersSignup.jsp"><p>New? Sign Up Here</p></a>
	</center>

</body>
</html>