package com.epam.controller.user;

import com.epam.dto.UserDto;
import com.epam.service.UserService;
import com.epam.service.impl.UserServiceImpl;
import com.epam.util.LoginUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if(LoginUtils.checkEmail(request.getParameter("email")) &&
                    LoginUtils.checkPassword(request.getParameter("password"))){
                Optional<UserDto> currentUser = Optional.of(
                        userService.login(request.getParameter("email"), request.getParameter("password")));
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", currentUser.get());
                request.getRequestDispatcher("/view/search-trains.jsp").forward(request, response);
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            request.setAttribute("failedMessage", "Bad credentials");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }
}