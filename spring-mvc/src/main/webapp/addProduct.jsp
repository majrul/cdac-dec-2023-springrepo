<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${ message }</h2>
<form action="add-product-v2">
Enter product name : <input type="text" name="name" /> <br />
Enter price : <input type="number" name="price" /> <br />
Enter quantity : <input type="number" name="quantity" /> <br />
<button type="submit">Add</button>
</form>
</body>
</html>