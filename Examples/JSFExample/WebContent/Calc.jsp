<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css" /> 
<title>Calculator</title>
</head>
<body bgcolor="#3388ff">
<f:view>
	<h:form id="Calc">
		<h1 align="center" style="color:Yellow">Calculator</h1>
		<br>
		<br>
		<div align="center">
		<h:panelGrid columns="2" rules="all" cellpadding="1" cellspacing="12" style="width: 446px; background-color: Gray; height: 148px; border-bottom-width: medium; border-bottom-style: solid; border-top-style: solid; border-left-color: #000000; border-top-color: Black; border-right-color: #000000; border-left-style: solid; border-right-width: medium; border-right-style: solid; border-left-width: medium; border-bottom-color: #000000; border-top-width: medium">
			<h:outputLabel value="Getal A" style="color: Yellow; text-align: center; background-position: center center"></h:outputLabel>
			<h:outputLabel value="Getal B" style="color: Yellow; text-align: center; background-position: center center"></h:outputLabel>
			<h:inputText id="getalA" value="#{calculatorBean.getalA}" style="text-align: center"></h:inputText>
			<h:inputText id="getalB" value="#{calculatorBean.getalB}" style="text-align: center"></h:inputText>
		</h:panelGrid></div>
		<br>
		<div align="center" style="position: relative; list-style-position: inside; list-style-type: sqaure; cursor: text">
		<h:messages errorStyle="color:White" showSummary="true" showDetail="false" style='background-color: Red; color: White; clear: both; line-height: normal; height: auto; text-align: center; font-variant: normal; width: auto; font-style: italic; font-size: 16px; text-decoration: blink; font-family: "Courier New", Courier; font-weight: bold; background-position: center center'></h:messages><br></div>
		<div align="center">
		<h:panelGrid columns="4" style='color: DarkCyan; font-style: italic; font-size: 12px; font-family: "Courier New", Courier; font-weight: bolder; width: 439px' cellspacing="10" cellpadding="1">
			<h:commandButton action="#{calculatorBean.getSom}" value="Som" tabindex="1" style="color: Sienna; text-align: center; height: auto; width: auto; bottom: auto; left: auto; right: auto; background-position: center center; top: auto"></h:commandButton>
			<h:commandButton action="#{calculatorBean.getVerschil}" value="Verschil" tabindex="2" style="color: Sienna; text-align: center"></h:commandButton>
			<h:commandButton action="#{calculatorBean.getProduct}" value="Product" tabindex="3" style="color: Sienna"></h:commandButton>
			<h:commandButton action="#{calculatorBean.getQuotient}" value="Quotiënt" tabindex="4" style="color: Sienna"></h:commandButton>
		</h:panelGrid></div>
		
		<br>
		<br>
		<h:panelGroup styleClass="CALCcenter2" style="width: 448px">
		<div align="center">
			<h3 align="center" style="color:yellow">Resultaat.</h3>
			<h:outputText value="#{calculatorBean.result}" style='color: Lime; background-color: Gray; font-style: italic; font-size: 20px; font-family: "Courier New", Courier; text-decoration: blink; font-weight: bold; text-align: center; height: 20px; width: 150px; border-bottom-width: thin; border-top-style: double; margin-bottom: auto; border-right-style: double; border-bottom-color: #000000; border-top-width: thin; border-bottom-style: double; margin-right: auto; border-left-color: #000000; border-top-color: #000000; border-left-style: double; border-right-color: #000000; border-right-width: thin; margin-left: auto; margin-top: auto; border-left-width: thin'></h:outputText>
			</div><br><br>
		</h:panelGroup>
		
		<hr>
            <div align="center">		
        
			<h:commandButton action="Verlaat" value="Verlaat" styleClass="MUNTcenter" style="color: Red; background-color: Silver"></h:commandButton><br><br><br><hr>
	   </div>	 
			
	</h:form>
</f:view>
</body>
</html>
