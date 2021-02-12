<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css" /> 
<title>Temperatuur Omvormer</title>
</head>
<body bgcolor="#3388ff">
<f:view>
     <h:form>
     <h1 align="center" style="color:yellow">Temperatuur omvormer</h1>
     <br>
	<h:panelGrid border="1" columns="3" style="width: 613px; height: 234px; background-color: Gray" styleClass="MUNTcenter">
		<h:outputLabel value="Om te vormen temperatuur " style="color: Yellow"></h:outputLabel>
		<h:outputText value="Celcius" style="color: Aqua"></h:outputText>
		<h:outputText value="#{tempBean.tempCResult}" rendered="true" style='color: Lime; font-style: italic; font-size: 14px; text-decoration: blink; font-family: "Courier New", Courier'></h:outputText>
		<h:inputText id="tempWaarde" value ="#{tempBean.tempWaarde}" rendered="true"></h:inputText>
		<h:outputText value="Farhenheit" style="color: Aqua"></h:outputText>
		<h:outputText value="#{tempBean.tempFResult}" rendered="true" style='color: Lime; font-style: italic; font-size: 14px; text-decoration: blink; font-family: "Courier New", Courier'></h:outputText>
		<h:outputText />
		<h:outputText value="Kelvin" style="color: Aqua"></h:outputText>
		<h:outputText value="#{tempBean.tempKResult}" rendered="true" style='color: Lime; font-style: italic; font-size: 14px; text-decoration: blink; font-family: "Courier New", Courier'></h:outputText>
	</h:panelGrid><br>
	<div align="center" >
	<h:message for="tempWaarde"  showDetail="true" style="background-color: Yellow; color: Black; text-decoration: blink"></h:message>
	<h:messages globalOnly="true"  showDetail="true" style="background-color: Red; color: White; text-decoration: blink" ></h:messages>
	</div><br><hr>
	<br>

	<h:panelGrid border="1" columns="3" style="width: 614px; height: 47px; background-color: Silver;;" styleClass="MUNTcenter1" >
		<h:outputText value="°C" style="text-align: center; color: #0000FF; background-color: #C0C0C0" ></h:outputText>
		<h:outputText value="°F" style="text-align: center; color: #0000FF; background-color: #C0C0C0"></h:outputText>
		<h:outputText value=" K" style="text-align: center; color: #0000FF; background-color: #C0C0C0"></h:outputText>
	</h:panelGrid>
		
	
<div align="center">
	<h:selectOneRadio  id="TempSchaal" layout="" required="true" value="#{tempBean.temperatuurSchaal}"  style="width: 611px; 
	background-color: Gray; height: 72px; color: Gray" styleClass="MUNTcenter1" requiredMessage="Gelieve een temperatuurschaal te kiezen !!">
		<f:selectItem itemValue="°C" />
		<f:selectItem itemValue="°F" />
		<f:selectItem itemValue="K" />
		</h:selectOneRadio><br></div>
		<div align="center">
		<h:message for="TempSchaal" showSummary="false" style="background-color: Red; color: White; text-decoration: blink"></h:message>
		<br><hr>
		<h:commandButton id="btn_Converteer" action="#{tempBean.Converteer}" value="Converteer" styleClass="MUNTcenter" style="color: Blue; background-color: Silver"></h:commandButton><br><br><br><hr>
		<h:commandButton action="Verlaat" value="Verlaat" styleClass="MUNTcenter" style="color: Red; background-color: Silver"></h:commandButton><br><br><br><hr>
		</div></h:form>
</f:view>
</body>
</html>