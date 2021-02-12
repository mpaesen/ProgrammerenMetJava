<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css" /> 
<title>Oefening 4</title>
</head>
<body bgcolor="#3388ff">
<f:view>
<h:form>
 <div align="center"><h1>Oefening 4 (Faces)</h1></div>
		<h:panelGrid border="1" columns="5" id="panel0"
			styleClass="MUNTcenter"
			style="width: 669px; background-position: center center; text-align: center; background-color: Gray; height: 326px">
			<h:outputText value="Calculator" style="color: Yellow"></h:outputText>
			<h:outputText />
			<h:outputText value="MuntConvertor" style="color: Yellow"></h:outputText>
			<h:outputText />
			<h:outputText value="TemperatuurConvertor" style="color: Yellow"></h:outputText>
			<h:graphicImage url="calculator.gif"
				style="background-position: center center"></h:graphicImage>
			<h:outputText />
			<h:graphicImage url="munt.gif"></h:graphicImage>
			<h:outputText />
			<h:graphicImage url="temperatuur.gif"></h:graphicImage>
			<h:commandButton value="Selecteer" action="A"
				style="width: 152px; color: Red"></h:commandButton>
			<h:outputText style="width:20" />
			<h:commandButton value="Selecteer" action="B"
				style="width: 152px; color: Red"></h:commandButton>
			<h:outputText style="width:100" />
			<h:commandButton value="Selecteer" action="C"
				style="width: 152px; color: Red"></h:commandButton>
		</h:panelGrid>
		<br>


	</h:form>

</f:view>
</body>
</html>