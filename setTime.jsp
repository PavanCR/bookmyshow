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
<h1>${msg }</h1>
<form action="showttime" method="get">

<input type="date" name="showdate"><br><br>
<input type="time" name="showtime"><br><br>
<button>Set</button>

</form>


</center>

</body>
</html>