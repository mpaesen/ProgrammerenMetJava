<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css" /> 
<title>MuntEenheid Omvormer</title>
</head>
<body bgcolor="#3388ff">
<f:view>
	
		<h1 align="center"><b><i style="color:yellow">Munteenheid omvormer</i></b></h1>
		<br>
		<br>
	<h:form id="f1"  style="height: 150px">
	       <div class="MUNTcenter" style="width: 442px; background-color: Black" align="center">
	       <h:panelGrid columns="2" rules="all" cellpadding="1" cellspacing="12" style="width: 434px; background-color: Gray; height: 170px; border-bottom-width: thick; border-bottom-style: solid; border-top-style: solid; border-left-color: Black; border-top-color: Black; border-right-color: Black; border-left-style: solid; border-right-width: thick; border-right-style: solid; border-left-width: thick; border-bottom-color: Black">
			<h:outputText value="Bedrag :" style="color: White; text-align: center" ></h:outputText>
			<h:outputText value="Geconverteerde waarde :" style="color: Aqua; background-color: Gray; text-align: center"></h:outputText>
			<h:inputText value="#{muntBean.bedrag}" style="text-align: center"></h:inputText>
			<h:panelGroup rendered="#{muntBean.aangepast!=true}" style="text-align: center">
				<h:outputLabel value="#{muntBean.result}" style='color: Lime; background-color: Gray; font-style: italic; font-size: 14px; text-decoration: blink; font-family: "Courier New", Courier; font-weight: bold; background-position: center center; position: relative; text-align: center'></h:outputLabel>
			</h:panelGroup>
		</h:panelGrid>
		</div>
		<br>
		<div align="center">
		<h:messages errorStyle="color:White" showDetail="true" style='background-color: Red; color: White; clear: both; line-height: normal; height: auto; text-align: center; font-variant: normal; width: auto; font-style: italic; font-size: 16px; text-decoration: blink; font-family: "Courier New", Courier; font-weight: bold; background-position: center center'></h:messages>
</div>
		<hr>
		<div class="MUNTcenter1" style="width: 457px" align="center">
		<h:panelGrid border="1" columns="2" style="width: 452px; height: 129px">
			<h:outputText value="Munteenheid van  : "></h:outputText>
			<h:outputText value="Munteenheid Naar  : "></h:outputText>
			<h:selectOneMenu id="Cmbx_1" value="#{muntBean.wisselkoersVan}"
				style="width: 132px">
				<f:selectItems value="#{muntBean.muntBenamingen}" />
			</h:selectOneMenu>
			<h:selectOneMenu id="Cmbx_2" value="#{muntBean.wisselkoersNaar}"
				style="width: 149px">
				<f:selectItems value="#{muntBean.muntBenamingen}" />
			</h:selectOneMenu>
		</h:panelGrid>
		</div>
		<br>
		<hr>
		<div class="MUNTcenter" align="center" style="width: 169px; background-color: #3388ff">
		<h:commandButton action="#{muntBean.berekenBedrag}" value="Converteer waarde" style="color: Blue"></h:commandButton><br></div>
		<hr>
		<div class="MUNTcenter" align="center" style="width: 169px; background-color: #3388ff">
		<h:commandButton action="Verlaat" value="Verlaat" styleClass="MUNTcenter" style="color: Red; width: 165px; background-color: Silver"></h:commandButton>
		<br>
		<br></div>
		<hr>
	</h:form>
	
		</f:view>
</body>
</html>