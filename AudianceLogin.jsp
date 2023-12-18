<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
 <color> <h1>${msg}</h1></color>
<form action="audianceLogin" method="post">
User Name<input type="email" name="email" placeholder="Enter Your email"><br><br>
Password<input type="password" name="password" placeholder="Enter Your Password"><br><br>
<button>Login</button> <button type="reset">cancel</button>
</form>
<a href="AudianceSignup.jsp"><p>New? Click Here</p></a>
</center>

</body>
</html>