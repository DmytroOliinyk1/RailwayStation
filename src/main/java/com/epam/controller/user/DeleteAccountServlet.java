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

@WebServlet(name = "DeleteAccountServlet", urlPatterns = ServletUrl.DELETE_ACCOUNT)
public class DeleteAccountServlet extends HttpServlet {
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
     * Method processes POST request for /delete-account url and
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Method processes GET request for /delete-account url and
     * deletes account
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser"));

            userService.deleteUser(currentUser.get().getUserId());
            request.setAttribute("successMessage", "Successful: account is deleted");
        } catch (RuntimeException e) {
            request.setAttribute("failedMessage", "Failed: couldn't delete account");
        } finally {
            request.getSession().invalidate();
            request.getRequestDispatcher(JspUrl.LOGIN).forward(request, response);
        }
    }
}