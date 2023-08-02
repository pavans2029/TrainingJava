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
              
                     int prodNumber=Integer.parseInt(request.getParameter("dno")); //read from HTML
                     String prodName = request.getParameter("dname");
                     double prodLoc = Double.parseDouble(request.getParameter("dloc"));
                     
                     Product prod = new Product();
                     prod.setProductId(prodNumber);
                     prod.setProductName(prodName);
                     prod.setProductPrice(prodLoc);
                     
                     prodService.createProductService(prod);
       %>
                     <h2> New Product Created </h2>
                     <a href="index.html"> Go Back Home</a>
       
</body>
</html>
