<%@page import="service.ProductServiceImplementation"%>
<%@page import="java.util.List"%>
<%@page import="entities.Product"%>
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
	<%
	ProductService prodService = new ProductServiceImplementation();
		
			int existingDeptNumber=Integer.parseInt(request.getParameter("dno")); //read from HTML
			
			
			prodService.removeProductService(existingDeptNumber);
	%>
			<h2> Existing Product Deleted </h2>
			<a href="index.html"> Go Back Home</a>
	
</body>
</html>