
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>Add / Edit a book</title>
</head>
  
<body>
	<f:view>
		<h:form>
		<h:inputHidden id="id" value="#{bookBean.id}"/>
		<h:panelGrid columns="2" border="1">
			
			<h:outputText value="Author:" />
			<h:inputText id="author" 
						 value="#{bookBean.author}">
			</h:inputText>
			
		    <h:outputText value="Title:" />
			<h:inputText id="title" 
					     value="#{bookBean.title}">
			</h:inputText>
			
			<h:outputText value="Available:" />
			<h:selectBooleanCheckbox id="available" 
									 value="#{bookBean.available}" />
		    
		</h:panelGrid>
		
		<h:messages id="errors" 
					style="color:red;font-weight:bold" 
					layout="table" />

		<h:commandButton value="Save" 
						 action="listBooks" 
						 actionListener="#{bookBean.saveBook}" />
		</h:form>
	</f:view>
</body>
</html>
