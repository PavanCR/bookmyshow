<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Producer Home</title>
</head>
<body>
<center>
<h1>${msg}</h1>
<form action="addfilms" method="post">
Movie Name<input type="text" name="film" value="${filmTital}" ><br><br>
Director name<input type="text" name="director" Palceholder="Enter Director Name"><br><br>
Leal Charactor<input type="text" name="lealname" Palceholder="Enter Your Lead Charactor Name"><br><br>
Producer Name<input type="text"  value="${producer}" readonly="readonly"><br><br>

   Hours:
        <input type="number" id="hours" name="hours" min="0" max="24" step="1">

      Minutes:
        <input type="number" id="minutes" name="minutes" min="0" max="59" step="1"><br><br>
<button>Submit</button><button type="reset">Cancel</button>
</form>
</center>
</body>
</html>