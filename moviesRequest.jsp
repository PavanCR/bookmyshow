<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>${msg }</h1>
		<table border="1">
			<tr>
				<th>Film Title</th>
				<th>Director</th>
				<th>Hero</th>
				<th>Hours</th>
				<th>mins</th>
				<th>Buy</th>
			</tr>

		
 <c:forEach var="film" items="${films }">
 <tr>
 <th>${film.getFilm() }</th>
 <th>${film.getDirector() }</th>
 <th>${film.getLealname() }</th>
 <th>${film.getHours() }</th>
 <th>${film.getMinutes() }</th>
 <th><a href="buymovie?id=${film.getId()}"><button>Get Movie</button></a></th>
 </tr>
 
 </c:forEach>
 </table>
	</center>
</body>
</html>