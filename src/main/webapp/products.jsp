<%@ page import="com.example.demo3.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo3.repo.ProductRepository" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product List</title>
</head>
<body>
<h1>Displaying Product List</h1>
<table border ="1" width="500" align="center">
    <tr >
        <th><b>Product id</b></th>
        <th><b>Product name</b></th>
        <th><b>Product price</b></th>
        <th><b>Actions</b></th>
    </tr>

    <%
       /* ArrayList<Product> products =
            (ArrayList<Product>)request.getAttribute("prod");
        */
        List<Product> products= (List<Product>) request.getAttribute("products");
        if(products!=null){
        for(Product p:products){%>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td>
            <a href="update?id=<%= p.getId() %>">Update</a>
            <a href="delete?id=<%= p.getId() %>">Delete</a>
        </td>
    </tr>
    <%}}%>
</table>

<br>
<a href="add.jsp">Add New Product</a>
<hr/>
</body>
</html>