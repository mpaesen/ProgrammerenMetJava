<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page import = "model.AdvantageCard" %>
<%@ page import = "java.util.Iterator" %>

<jsp:useBean id="resultBean" class="view.ResultBean"
             type="view.ResultBean" scope="session"></jsp:useBean>
<jsp:useBean id="actueelElement" class="model.AdvantageCard"
	type="model.AdvantageCard" scope="session"></jsp:useBean>
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
<LINK href="theme/Master.css" rel="stylesheet"
      type="text/css">
<TITLE>Advantage Card</TITLE>
</HEAD>
<BODY>
<P><IMG border="0" src="theme/AdeccoLogo.gif" width="150" height="50"></P>
<center>
<H1>Advantage Card</H1>
</center>
<P><BR>
<BR><h3><%= resultBean.getOffice()%></h3>
<BR>
</P>
<TABLE border="2" cellpadding="0" cellspacing="5">
	<TBODY>
		<TR>
			<TH bgcolor="#d4d0c8" nowrap>
			<H2 align="center">Tempno</H2>
			</TH>
			<TD bgcolor="#d4d0c8" nowrap width="299">
			<H2 align="center">Name of temp</H2>
			</TD>
			<TD bgcolor="#d4d0c8">
			<H2>Expiration<BR>
			Date Card</H2>
			</TD>
			<TD bgcolor="#d4d0c8">
			<H2>Status<BR>
			Card</H2>
			</TD>
		</TR>

<% // start scriptlet
 	
		for (Iterator it = resultBean.getList().iterator();it.hasNext();) { 
		session.setAttribute("actueelElement",(AdvantageCard)it.next());%>			
				
		<TR>
			<TD bgcolor="#ccffcc" nowrap align="right"><jsp:getProperty name="actueelElement" property="tempNo" /></TD>
			<TD bgcolor="#ccffcc"  nowrap align="left"><jsp:getProperty name="actueelElement" property="tempName" /></TD>
			<TD bgcolor="#ccffcc" nowrap align="right"><jsp:getProperty name="actueelElement" property="cardExpiration" /></TD>
			<TD bgcolor="#ccffcc" nowrap align="right"><jsp:getProperty name="actueelElement" property="cardStatus" /></TD>			
		</TR>
		<% } %>
	</TBODY>

</TABLE>
</BODY>
</HTML>
