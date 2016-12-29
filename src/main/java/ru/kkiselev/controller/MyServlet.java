package ru.kkiselev.controller;

import ru.kkiselev.model.POJO.Product;
import ru.kkiselev.service.ProductService;
import ru.kkiselev.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kv on 23.12.16.
 */

@WebServlet()
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("message");
        if ((name == "")||(name == null)){
            name = "nothing";
        }

        List users = null;
        UserService us = new UserService();
        try {
            users = us.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List products = null;
        ProductService ps = new ProductService();
        try {
            products = ps.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("message", name);
        request.setAttribute("users", users);
        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        request.getSession(true);

    }
}
