<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="Pages/KassaStyles.css" />
    <title>Struts 2 DisplayEmployee</title>
  </head>
  <body>
    <h2>De kassa werd aangezet door:</h2>
    <ul>
	    <li> <s:property value="employee.PersonID" /></li>
	    <li> <s:property value="employee.Name" /></li>
	    <li> <s:property value="employee.Address" /></li>
    </ul>
    <br><br>
    <h2>Kassier login om de kassa te openen</h2>
	<s:form action="GetEmployee2">
		<s:textfield name="nummer" label="Geef het employee nummer (bijv. 9001): "/>
		<s:submit value="Login" />
	</s:form>
  </body>
</html>