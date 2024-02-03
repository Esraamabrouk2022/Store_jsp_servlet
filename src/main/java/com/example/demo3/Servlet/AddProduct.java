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

@WebServlet("/add")
public class AddProduct extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductRepository productRepository= (ProductRepository) getServletContext().getAttribute("productRepo");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productRepository.addProduct(product);

        response.sendRedirect("products");
   }
}