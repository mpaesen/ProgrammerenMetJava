<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="Pages/KassaStyles.css" />
	<title>nextgenPOS Hibernate and Struts.</title>
</head>
<body>
<h2>Manager login om de kassa te starten</h2><br>
<s:form action="GetEmployee">
	<s:textfield name="nummer" label="Geef het employee nummer (bijv. 9000)" size="4"/>
	<s:submit value="Login" />
</s:form>
</body>
</html>


