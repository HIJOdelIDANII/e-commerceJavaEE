package controller;

import dao.UserDAO;
import model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userDAO.validateUser(username, password)) {
            User user = userDAO.findUserByUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("produits");
        } else {
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
    }
}