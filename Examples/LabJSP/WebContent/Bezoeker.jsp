<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=STYLESHEET href="JSP-Style.css" type="text/CSS">

<title>Welkom pagina.</title>
</head>
<body>
<h1>Welkom page.</h1>

<!-- gebruik maken van een request parameter -->
<br><br>
<h2>Deze jsp werd aangeroepen via:<%=request.getAttribute("Oproeper") %>,<br>Welkom op deze jsp pagina.</h2>



<!-- Bean data gebruiken in een jsp pagina dmv useBean en getProperty -->
<h3>Ophalen van de bean uit de session door jsp:useBean + jsp:getProperty:<br></h3>
<jsp:useBean id="bezoeker" class="com.groept.be.model.Visitor" scope="session"/>
<h2>Hallo <jsp:getProperty name="bezoeker" property="name"/>,<br>Welkom op deze jsp pagina.</h2>



<!-- Bean data gebruiken in een jsp via java code -->
<h3>Ophalen van de bean uit de session dmv javacode(scriptlet + expression):<br></h3>
<!-- import -->
<%@ page import="com.groept.be.model.Visitor" %>
<% Visitor visitor = (Visitor)request.getSession().getAttribute("bezoeker"); %>

<!-- oproepen van de property via java code -->
<h2>Hallo <%=visitor.getName()%>,<br>Welkom op deze jsp pagina.</h2>
<%System.out.println(visitor.getName()); %>


</body>
</html>

