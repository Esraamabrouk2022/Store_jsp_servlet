package com.example.demo3;

import com.example.demo3.repo.ProductRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        // Initialize doctorRepo
        ProductRepository productRepository=new ProductRepository();

        servletContext.setAttribute("productRepo", productRepository);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Clean-up code, if any
    }
}