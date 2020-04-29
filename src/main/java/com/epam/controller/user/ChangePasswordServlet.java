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
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = "/change-password")
public class ChangePasswordServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Optional<UserDto> currentUser = Optional.ofNullable(
                    (UserDto) request.getSession().getAttribute("currentUser"));
            if (LoginUtils.checkPassword(request.getParameter("newPassword"))) {
                if (!currentUser.isPresent()) {
                    if (userService.changePassword(request.getParameter("newPassword"), request.getParameter("email"))) {
                        request.setAttribute("successMessage", "Successful: password changed");
                    } else {
                        request.setAttribute("failedMessage", "Failed: couldn't change password ");
                    }

                } else {
                    if (currentUser.get().getEmail().equals(request.getParameter("email"))) {
                        if (userService.changePassword(request.getParameter("newPassword"), request.getParameter("email"))) {
                            request.setAttribute("successMessage", "Successful: password changed");
                        } else {
                            request.setAttribute("failedMessage", "Failed: couldn't change password ");
                        }
                    } else {
                        request.setAttribute("failedMessage", "Failed: bad credentials");
                    }
                }
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            request.setAttribute("failedMessage", "Failed: couldn't change password ");
        } finally {
            request.getSession().invalidate();
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/change-password").forward(request, response);
    }
}
