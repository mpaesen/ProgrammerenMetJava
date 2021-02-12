 
<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
 
<html> 
	<head>
		<title>Edit a book</title>
	</head>
	<body>
		<%-- create a html form --%>
		<html:form action="bookEdit">
			<%-- print out the form data --%>
			<table border="1">
				<tr>
					<td>Author:</td>
					<td><html:text property="author" /></td>
				</tr>
				<tr>
					<td>Title:</td>
					<td><html:text property="title" /></td>
				</tr>
				<tr>
					<td>Available:</td>
					<td><html:checkbox property="available" /></td>
				</tr>				
				<tr>
					<td colspan="2">
						<html:submit>Save</html:submit>
					</td>
				</tr>
			</table>
			<%-- hidden field that contains the id of the book --%>
			<html:hidden property="id" />
			
			<%-- set the parameter for the dispatch action --%>
			<html:hidden property="do" value="saveBook" />	
		</html:form>
	</body>
</html>
