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

@WebServlet("/delete")
public class DeletProduct extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRepository productRepository= (ProductRepository) getServletContext().getAttribute("productRepo");

        int id=Integer.parseInt(request.getParameter("id"));
        productRepository.deleteProduct(id);
        response.sendRedirect("products");
       // request.getRequestDispatcher("products.jsp").forward(request, response);

    }
}
