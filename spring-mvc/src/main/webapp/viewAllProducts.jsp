<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${ listOfProducts }" var="p">
	ID : ${ p.id } <br />
	Name : ${ p.name } <br />
	Price : ${ p.price } <br />
	Quantity : ${ p.quantity } <br />
	===================== <br />
</c:forEach>
</body>
</html>

<%--
for(Product p : listOfProducts) {

}
--%>