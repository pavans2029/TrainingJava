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
		String newDeptName = request.getParameter("dname");
		String newDeptLoc = request.getParameter("dloc");
		
		Retailer dept = new Retailer();
		dept.setRetailerId(existingDeptNumber);
		dept.setRetailerName(newDeptName);
		dept.setRetailerEmail(newDeptLoc);
		
		deptService.modifyRetailerService(dept);
		
		
	%>
			<h2> New Retailer Modified </h2>
			<a href="index.html"> Go Back Home</a>
	
</body>
</html>