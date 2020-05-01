package com.epam.controller.user;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.UserDto;
import com.epam.exception.IncorrectDataException;
import com.epam.exception.NotFoundException;
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

@WebServlet(name = "LoginServlet", urlPatterns = ServletUrl.LOGIN)
public class LoginServlet extends HttpServlet {
    private UserService userService;

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
     * Method processes POST request for /login url and
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (LoginUtils.checkEmail(request.getParameter("email")) &&
                    LoginUtils.checkPassword(request.getParameter("password"))) {
                Optional<UserDto> currentUser = Optional.of(
                        userService.login(request.getParameter("email"), request.getParameter("password")));
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", currentUser.get());
                request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
            } else {
                throw new IncorrectDataException("Incorrect email or password");
            }
        } catch (RuntimeException e) {
            request.setAttribute("failedMessage", "Bad credentials");
            request.getRequestDispatcher(JspUrl.LOGIN).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /login url and forward to
     * forward to /view/login.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JspUrl.LOGIN).forward(request, response);
    }
}