package com.epam.controller.user;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.UserDto;
import com.epam.service.UserService;
import com.epam.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet is used for deleting account.
 */
@WebServlet(name = "DeleteAccountServlet", urlPatterns = ServletUrl.DELETE_ACCOUNT)
public class DeleteAccountServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteAccountServlet.class);

    private UserService userService;

    /**
     * Method initializes resources.
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    /**
     * Method processes POST request for /delete-account url and
     * deletes account.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser"));

            userService.deleteUser(currentUser.get().getUserId());
            LOGGER.info("Deleted user");
            request.setAttribute("successMessage", "Successful: account is deleted");
        } catch (RuntimeException e) {
            LOGGER.error("RuntimeException: " + e.getMessage());
            request.setAttribute("failedMessage", "Failed: couldn't delete account");
        } finally {
            request.getSession().invalidate();
            request.getRequestDispatcher(JspUrl.LOGIN).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /delete-account url and
     * forward to /delete-history url.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser"));

            request.getRequestDispatcher(ServletUrl.DELETE_HISTORY).forward(request, response);
        } catch (RuntimeException e) {
            LOGGER.info("RuntimeException: " + e.getMessage());
            request.getRequestDispatcher(JspUrl.LOGIN).forward(request, response);
        }
    }
}