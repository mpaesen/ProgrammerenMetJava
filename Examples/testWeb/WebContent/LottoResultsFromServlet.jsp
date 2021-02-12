<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%-- page settings --%>

<%@ page import="lotto.model.LottoCombination"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Lotto</title>

<style type="text/css">
         body { 
            font-family: tahoma, helvetica, arial, sans-serif; 
         }

         table, tr, td, th { 
            text-align: center;
            font-size: .9em;
            border: 3px groove;
            padding: 5px;
            background-color: #dddddd;
         }
      </style>
</head>

<body>
<p style="font-size: 2em;">Lotto Combinaties</p>

<table>
	<thead>
		<tr>
			<th style="width: 174px">Combinatie</th>
		</tr>
	</thead>

	<tbody>

		<% // start scriptlet
		ArrayList serializedList = (ArrayList)request.getAttribute("inputFile");

		LottoCombination actueelElement;
		for (Iterator it = serializedList.iterator();it.hasNext();) {
				actueelElement = (LottoCombination)it.next();				
         %>
		<%-- end scriptlet; insert fixed template data --%>
		<tr>
			<td><%= actueelElement.toString() %></td>
			<%
		}
		%>
		</tr>
	</tbody>
</table>
</body>

</html>
