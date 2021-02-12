<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=STYLESHEET href="JSP-Style.css" type="text/CSS">

<title>Registration page.</title>
</head>
<body>
<h1>Registratie pagina.<br><br></h1>

<h2>Gelieve je naam en nickname te kiezen aub.<br><br></h2>
<form action="BezoekerServlet" method="Post">
        Naam: <input type="text" name="Name" size="20"><br>
        <br>
        Nick: <input type="text" name="Nick" size="20"><br><br><br>
<input type="submit" value="Submit">

</form>
    
</body>
</html>