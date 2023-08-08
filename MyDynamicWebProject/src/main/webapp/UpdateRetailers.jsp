<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entities.Retailer"%>
<%@page import="java.util.List"%>
<%@page import="service.RetailerServiceImplementation"%>
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

	<h1>Showing all the Retailers</h1>
	<%
	RetailerService deptService = new RetailerServiceImplementation();
	List<Retailer> deptList = deptService.findRetailersService();
	%>
	<%
		for (Retailer dept : deptList) {
		%>
	<form action="UpdateRetailer.jsp">
	<table border=5 cellspacing=10 cellpadding=10>
		<tr>
			<th>RETAILER NO</th>
			<th>RETAILER NAME</th>
			<th>RETAILER EMAIL</th>
			<th>RETAILER PHONE</th>
			<th>RETAILER ADDRESS</th>
			<th>RETAILER PIN CODE</th>
			<th>VERIFICATION STATUS</th>
		</tr>
		
		
		<tr>
			<td><%=dept.getRetailerId()%></td>
			<td><input type=text name="retailer-name"
				value="<%=dept.getRetailerName()%>"></td>
			
			<td><input type=text name="retailer-email"
				value="<%=dept.getRetailerEmail()%>"></td>
			<td><input type=text name="retailer-phone"
				value="<%=dept.getRetailerPhone()%>"></td>
			<td><input type=text name="retailer-address"
				value="<%=dept.getRetailerAddress()%>"></td>
			<td><input type=text name="retailer-postalcode"
				value="<%=dept.getRetailerPostalCode()%>"></td>
			
			<% if (dept.isRetailerIsVerified()) { %>
    <td><input type="checkbox" name="retailer-verification" checked
               ></td>
<% } else { %>
    <td><input type="checkbox" name="retailer-verification"
               ></td>
<% } %>
			

			<td>
				
					<input type="hidden" name="retailer-id" value="<%=dept.getRetailerId()%>"><br>
					<input type=submit name=submit value="Update Retailer">
				
			</td>


		</tr>
		
	</table>
	</form>
	<%
		}
		%>
	<a href="index.html"> Go Back Home</a>


</body>
</html>