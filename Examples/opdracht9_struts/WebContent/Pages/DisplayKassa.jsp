<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="Pages/KassaStyles.css" />
<title>Struts 2 DisplayKassa</title>
</head>
<body>
	<h2>KASSA</h2>

	<p>Kassier: <s:property value="employee"/></p>

<s:if test="customer.Name !=null">
		<p>Klant: <s:property value="customer.Name" /></p>
	
<h3>Producten</h3>
<table>
	<tr style="height: 37px;" align="right" bgcolor="blue">
		<th>ID</th>
		<th>Description</th>
		<th>Price</th>
		<th>ID</th>
		<th>Aantal</th>
		<th>Bestel</th>
	</tr>
	<s:form action="Order">
			<s:iterator value="producten">
				<tr>
				<td><s:property value="productID" /></td>
				<td><s:property value="description" /></td>
					<td><s:property value="price" /></td>						
					<td><s:hidden name="productID" label="productID: "/></td>
					<td><s:textfield name="aantal" label="aantal: "/></td>
					<td><s:submit value="Bestel" /></td>

				</tr>
			</s:iterator>
			</s:form>
		</table>

	
	aantal bestelde producten:
	<s:property value = "test"/>
	
	</s:if>
	<s:else>
	<h2>Geef Klantnummer in</h2>
	<s:form action="GetCustomer">
		<s:hidden name ="employee"/>
		<s:textfield name="nummer" label="Geef het klantnummer (bijv 1001): "/>
		<s:submit value="OK" />
	</s:form>
	</s:else>
	

</body>
</html>