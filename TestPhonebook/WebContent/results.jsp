<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESULTS</title>
</head>
<body>
<h1 align="center">Details</h1>
<%
List result=(List)request.getAttribute("result");
%>
<p>
<table border="2">
<tr>
<td><b>Name</b></td>
<td><b>Address</b></td>
<td><b>Phone</b></td>
</tr>
<tr>
<td><b><%out.print(result.get(0));%></b></td>
<td><b><% out.print(result.get(1));%></b></td>
<td><b><% out.print(result.get(2)); %></b></td>
</tr>
</table>
</body>
</html>