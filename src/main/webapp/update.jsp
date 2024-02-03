<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
</head>
<body>
<h2>Update Product</h2>
<form action="update" method="post">
    <input type="hidden" name="id" value="${id}"><br>
    Name: <input type="text" name="name" value="<%= request.getAttribute("name") %>"><br><br>
    Price: <input type="text" name="price" value="<%= request.getAttribute("price") %>"><br><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
