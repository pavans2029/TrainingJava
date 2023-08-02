<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="service.ProductServiceImplementation"%>
<%@page import="service.ProductService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Showing all the Products </h1>	
	<%
		

				ProductService prodService = new ProductServiceImplementation();
				List<Product> prodList = prodService.findProductsService();
		%>
	<table border=5 cellspacing=10 cellpadding=10>
		<tr>
			<th> DEPT NO </th>
			<th> DEPT NAME </th>
			<th> DEPT LOCATION </th>
		</tr>
	<% for(Product prod : prodList) { %>
		<tr>
			<td> <%=prod.getProductId() %></td>
			<td> <input type=text name="dname" value="<%=prod.getProductName()%>"></td>
			<td> <%=prod.getProductName() %></td>
			<td> <button>Update</button></td>
			<td> <button>Delete</button></td>
			
		
		</tr>
	<% } %>
	</table>
	
		<a href="index.html"> Go Back Home</a>
	
	
</body>
</html>