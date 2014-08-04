<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="ims.dto.PartDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Behold! All of your products!</title>
</head>

<%
	ArrayList<PartDto> allParts = (ArrayList<PartDto>) request.getAttribute("allParts");
%>

<body>
	<a href="/InventoryManagementSystem/ManagePart.jsp">Back</a>
	<hr>

	<table border="1">
		<thead>
			<tr>
				<td>Product Name</td>
				<td>Quantity</td>
				<td>Price</td>
				<td>Update</td>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < allParts.size(); i++) {
					PartDto part = allParts.get(i);
			%>
			<tr>
				<td><%=part.getName() %></td>
				<td><%=part.getQuantity() %></td>
				<td><%=part.getPrice() %></td>
				<td><a href="UpdatePartServlet?id=<%=part.getId()%>">Update</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>