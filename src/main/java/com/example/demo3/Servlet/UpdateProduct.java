package com.example.demo3.Servlet;

import com.example.demo3.model.Product;
import com.example.demo3.repo.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/update")
public class UpdateProduct extends HttpServlet {

    int id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductRepository productRepository= (ProductRepository) getServletContext().getAttribute("productRepo");
        id=Integer.parseInt(request.getParameter("id"));
        Product product= productRepository.findProduct(id);
        request.setAttribute("id",id);
        request.setAttribute("name",product.getName());
        request.setAttribute("price",product.getPrice());
      //  response.sendRedirect("update.jsp");
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // int id = Integer.parseInt(request.getParameter("id"));

       ProductRepository productRepository= (ProductRepository) getServletContext().getAttribute("productRepo");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        productRepository.updateProduct(id,product);
        response.sendRedirect("products");
       // request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
