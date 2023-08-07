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
	<table border=5 cellspacing=10 cellpadding=10>
		<tr>
			<th>RETAILER NO</th>
			<th>RETAILER NAME</th>
			<th>RETAILER EMAIL</th>
		</tr>
		<%
		for (Retailer dept : deptList) {
		%>
		
		<tr>
			<td><%=dept.getRetailerId()%></td>
			<td><input type=text name="dname"
				value="<%=dept.getRetailerName()%>"></td>
			<td><%=dept.getRetailerEmail()%></td>
			<td>
				<button>Update</button>
			</td>

			<td>
				<form action="DeleteRetailer.jsp">
					<input type="hidden" name="dno" value="<%=dept.getRetailerId()%>"><br>
					<input type=submit name=submit value="Delete Retailer">
				</form>
			</td>


		</tr>
		<%
		}
		%>
	</table>

	<a href="index.html"> Go Back Home</a>


</body>
</html>