<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<jsp:useBean id="exception" class="java.sql.SQLException"
	scope="session"></jsp:useBean>
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Advantage Card</TITLE>
</HEAD>
<BODY bgcolor="#333333">
<P><IMG border="0" src="theme/AdeccoLogo.gif" width="150" height="50"></P>
<center>
<H1>Advantage Card</H1>
</center>
<H2 align="center">An Error occured!</H2>

<H2>SQLException:</H2>

<jsp:getProperty name="exception" property="class" />
<H2>SQL State:</H2>
<jsp:getProperty name="exception" property="SQLState" />
<H2>Message:</H2>
<jsp:getProperty name="exception" property="message" />
<H2>Error code:</H2>
<jsp:getProperty name="exception" property="errorCode" />


<H3 align="center"><FONT color="#ff0000">Do NOT close this page before
you've called the IT HelpDesk!</FONT></H3>
</BODY>
</HTML>
