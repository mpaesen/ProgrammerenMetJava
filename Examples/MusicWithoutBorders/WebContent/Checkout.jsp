<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="true" import="shopping.CD, java.util.ArrayList" %>
<html>
<head>
<title>Music Without Borders Checkout</title>
</head>
<body bgcolor="#33CCFF">
 <font face="Times New Roman,Times" size=+3>
  Music Without Borders Checkout
 </font>
 <hr><p>
 <center>
 <table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
 <tr>
 <td><b>ALBUM</b></td>
 <td><b>ARTIST</b></td>
 <td><b>COUNTRY</b></td>
 <td><b>PRICE</b></td>
 <td><b>QUANTITY</b></td>
 <td></td>
 </tr>
 <%
  ArrayList<CD> buylist = (ArrayList<CD>) session.getValue("shopping.shoppingcart");
  String amount = (String) request.getAttribute("amount");
  for (int i=0; i < buylist.size();i++) {
   CD anOrder = (CD) buylist.get(i);
 %>
 <tr>
 <td><b><%= anOrder.getAlbum() %></b></td>
 <td><b><%= anOrder.getArtist() %></b></td>
 <td><b><%= anOrder.getCountry() %></b></td>
 <td><b><%= anOrder.getPrice() %></b></td>
 <td><b><%= anOrder.getQuantity() %></b></td>
 </tr>
 <%
  }
  session.invalidate();
 %>
 <tr>
 <td>     </td>
 <td>     </td>
 <td><b>TOTAL</b></td>
 <td><b>$<%= amount %></b></td>
 <td>     </td>
 </tr>
 </table>
 <p>
 <a href="/EShop.jsp">Shop some more!</a>
 </center>
</body>
</html>