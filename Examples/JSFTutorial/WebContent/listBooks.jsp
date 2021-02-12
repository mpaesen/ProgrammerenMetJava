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

	<title>List of books</title>
</head>
  
<body>
	<f:view>
		<h:form id="bookList">
		<h:dataTable id="books" 
					 value="#{bookListBean.books}" 
					 var="book" 
					 border="1">   
		  <h:column>
		    <f:facet name="header">
		     <h:outputText  value="Author"/>
		    </f:facet>
		    <h:outputText value="#{book.author}" />
		  </h:column>
		  <h:column>
		    <f:facet name="header">
		      <h:outputText  value="Title"/>
		    </f:facet>
		    <h:outputText value="#{book.title}" />
		  </h:column>
		  <h:column>
		    <f:facet name="header">
		      <h:outputText  value="Available"/>
		    </f:facet>
		    <h:selectBooleanCheckbox disabled="true" 
		    						 value="#{book.available}" />
		  </h:column>
		  <h:column>
		    <f:facet name="header">
		      <h:outputText  value="Edit"/>
		    </f:facet>
		    <h:commandLink id="Edit" 
		    			   action="editBook" 
		    			   actionListener="#{bookBean.selectBook}">
		    	<h:outputText value="Edit" />
		    	<f:param id="editId" 
		    			 name="id" 
		    			 value="#{book.id}" />
		    </h:commandLink>
		  </h:column>
		   <h:column>
		    <f:facet name="header">
		      <h:outputText  value="Delete"/>
		    </f:facet>
		    <h:commandLink id="Delete" 
		    			   action="listBooks" 
		    			   actionListener="#{bookBean.deleteBook}">
		    	<h:outputText value="Delete" />
		    	<f:param id="deleteId" 
		    			 name="id" 
		    			 value="#{book.id}" />
		    </h:commandLink>
		  </h:column>
		</h:dataTable> 
		
		<h:commandLink id="Add" 
					   action="editBook" 
					   actionListener="#{bookBean.initBook}">
			<h:outputText value="Add a book" />
		</h:commandLink>
		</h:form>
	</f:view>
</body>
</html>
