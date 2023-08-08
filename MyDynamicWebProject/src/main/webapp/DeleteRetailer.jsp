<%@page import="service.RetailerServiceImplementation"%>
<%@page import="java.util.List"%>
<%@page import="entities.Retailer"%>
<%@page import="service.RetailerService"%>
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
		RetailerService deptService = new RetailerServiceImplementation();
	
		int existingDeptNumber=Integer.parseInt(request.getParameter("dno")); //read from HTML
		
		
		deptService.removeRetailerService(existingDeptNumber);
		
		
	%>
			<h2> Existing Retailer Deleted </h2>
			<a href="index.html"> Go Back Home</a>
	
</body>
</html>