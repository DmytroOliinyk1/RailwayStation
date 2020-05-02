package com.epam.controller.user;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.UserDto;
import com.epam.dto.mapper.UserDtoMapper;
import com.epam.entity.User;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "RegistrationServlet", urlPatterns = ServletUrl.REGISTRATION)
public class RegistrationServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServlet.class);

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
     * Method processes POST request for /registration url and
     * saves new user
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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
                LOGGER.info("Saved  user in database");
            } else {
                throw new IncorrectDataException("Incorrect input data");
            }
        } catch (RuntimeException e) {
            LOGGER.error("RuntimeException: " + e.getMessage());
            request.setAttribute("failedMessage", "Failed: couldn't create account");
        } finally {
            request.getSession().invalidate();
            request.getRequestDispatcher(JspUrl.LOGIN).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /registration url and
     * forward /view/login.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JspUrl.REGISTRATION).forward(request, response);
    }
}
