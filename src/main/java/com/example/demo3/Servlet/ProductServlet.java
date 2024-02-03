package com.example.demo3.Servlet;

import com.example.demo3.model.Product;
import com.example.demo3.repo.ProductRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext=getServletContext();
        ProductRepository productRepository= (ProductRepository) servletContext.getAttribute("productRepo");

        List<Product> products = productRepository.findProducts();

        req.setAttribute("products", products);
       // resp.sendRedirect("products.jsp");
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
