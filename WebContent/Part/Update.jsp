<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ims.dto.PartDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<%PartDto partDto = (PartDto)request.getAttribute("partDto");%>

<body>
<form method="post" action="UpdatePartServlet">
	<input type="hidden" name="id" value="<%= partDto.getId() %>"/>
	<h2>Update your part!</h2>
	<table> 
		<tr>
			<td>Name</td>
			<td>
				<input type="text" name="name" value="<%= partDto.getName()%>"/>
			</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>
				<input type="text" name="price" value="<%= partDto.getPrice()%>"/>
			</td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td>
				<input type="text" name="quantity" value="<%= partDto.getQuantity()%>"/>
			</td>
		</tr>
		<tr>
			<td>
				<a href="DeleteServlet?id=<%=partDto.getId() %>">Delete</a>
			</td>
		</tr>
	</table>
	<input type="submit">
</form>
</body>
</html>