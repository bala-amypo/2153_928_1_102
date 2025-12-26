// src/main/java/com/example/demo/servlet/HealthServlet.java
package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HealthServlet", urlPatterns = "/health", loadOnStartup = 1)
public class HealthServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        // Initialization code
        System.out.println("HealthServlet initialized");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        
        PrintWriter out = resp.getWriter();
        out.print("OK");
        out.flush();
    }
    
    @Override
    public void destroy() {
        // Cleanup code
        System.out.println("HealthServlet destroyed");
    }
}