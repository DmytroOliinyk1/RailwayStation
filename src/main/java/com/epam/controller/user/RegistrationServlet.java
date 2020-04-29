package com.epam.controller.user;

import com.epam.dto.UserDto;
import com.epam.dto.mapper.UserDtoMapper;
import com.epam.entity.User;
import com.epam.service.UserService;
import com.epam.service.impl.UserServiceImpl;
import com.epam.util.LoginUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (LoginUtils.checkEmail(request.getParameter("email")) &&
                    LoginUtils.checkPassword(request.getParameter("password")) &&
                    LoginUtils.checkName(request.getParameter("name"), request.getParameter("surname"))) {
                UserDto userDto = new UserDtoMapper().fromDtoToEntity(
                        new User(
                                request.getParameter("email"), request.getParameter("password"),
                                request.getParameter("name"), request.getParameter("surname")
                        )
                );

                userService.save(userDto);
                request.setAttribute("successMessage", "Successful: account created");
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            request.setAttribute("failedMessage", "Failed: couldn't create account");
        } finally {
            request.getSession().invalidate();
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }
}