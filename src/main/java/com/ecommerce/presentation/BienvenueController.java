package com.ecommerce.presentation;

import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/Bienvenue")
public class BienvenueController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Optionally do some logic, then forward
        request.getRequestDispatcher("/WEB-INF/views/Bienvenue.jsp").forward(request, response);
    }
}
