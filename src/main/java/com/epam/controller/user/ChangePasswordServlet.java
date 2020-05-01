package com.epam.controller.user;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.UserDto;
import com.epam.exception.IncorrectDataException;
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

@WebServlet(name = "ChangePasswordServlet", urlPatterns = ServletUrl.CHANGE_PASSWORD)
public class ChangePasswordServlet extends HttpServlet {
    UserService userService;

    /**
     * Method initializes resources
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    /**
     * Method processes POST request for /change-password url and
     * changes account password
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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
                throw new IncorrectDataException("Password is empty");
            }
        } catch (RuntimeException e) {
            request.setAttribute("failedMessage", "Failed: couldn't change password ");
        } finally {
            request.getSession().invalidate();
            request.getRequestDispatcher(JspUrl.LOGIN).forward(request, response);
        }

    }

    /**
     * Method processes GET request for /change-password url and
     * forwards to /view/change-password.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JspUrl.CHANGE_PASSWORD).forward(request, response);
    }
}
