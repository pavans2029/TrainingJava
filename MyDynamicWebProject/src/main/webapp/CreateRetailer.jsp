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
	RetailerService retailerService = new RetailerServiceImplementation();
	
	int existingRetailerId=Integer.parseInt(request.getParameter("retailer-id")); //read from HTML
	String newRetailerName = request.getParameter("retailer-name");
	String newRetailerEmail = request.getParameter("retailer-email");
	String newRetailerPhone = request.getParameter("retailer-phone");
	String newRetailerAddress = request.getParameter("retailer-address");
	String newRetailerPostalcode = request.getParameter("retailer-postalcode");
	String newRetailerVerification = request.getParameter("retailer-verification");
	boolean isRetailerVerified = "on".equals(newRetailerVerification);
	
	Retailer retailer = new Retailer();
	retailer.setRetailerId(existingRetailerId);
	retailer.setRetailerName(newRetailerName);
	retailer.setRetailerEmail(newRetailerEmail);
	retailer.setRetailerPhone(newRetailerPhone);
	retailer.setRetailerAddress(newRetailerAddress);
	retailer.setRetailerPostalCode(newRetailerPostalcode);
	retailer.setRetailerIsVerified(isRetailerVerified);
	
	retailerService.createRetailerService(retailer);
		
		
	%>
			<h2> New Retailer Created </h2>
			<a href="index.html"> Go Back Home</a>
	
</body>
</html>