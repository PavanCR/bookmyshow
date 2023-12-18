<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>${msg }</h1>
<form action="setTiming" method="post" >
name<input type="text" name="theatername" value="${theater }" readonly="readonly"><br><br>
seats<input type="number" name="seats" placeholder="Enter Seat Capacity"><br><br>
Location<input type="text" name="location" placeholder="Enter Location"><br><br>
<button>Save</button> <button type="reset">Cancel</button>
</form>
<a href="moviesRequest"><button>See Movie Requests</button></a>
<a href="broughtMovies"><button>Brought Movies</button></a>
</center>
</body>
</html>