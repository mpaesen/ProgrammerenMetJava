<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error pagina with declaration and servlet.</title>
</head>
<body bgcolor="RED">
<h2>Hallo daar, er ging blijkbaar wat fout.<br></h2>
<br><br>
<!-- declaration -->
<%!private String url;%>

<!-- servlet -->
<%
if(request.getAttribute("Caller")!=null && request.getAttribute("Caller").equals("Create"))
	url="RegisterBezoeker.jsp";
else
	url="index.jsp";
%>
<a href="<%=url%>">Klik hier om verder te gaan.</a>

</body>
</html>