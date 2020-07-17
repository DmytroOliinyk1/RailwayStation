package com.epam.controller.history;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.controller.user.LoginServlet;
import com.epam.dto.HistoryDto;
import com.epam.dto.UserDto;
import com.epam.service.HistoryService;
import com.epam.service.impl.HistoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet is used for getting history of booking.
 */
@WebServlet(name = "GetHistoryServlet", urlPatterns = ServletUrl.GET_HISTORY)
public class GetHistoryServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetHistoryServlet.class);

    HistoryService historyService;

    /**
     * Method initializes resources
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        historyService = new HistoryServiceImpl();
    }

    /**
     * Method processes POST request for /get-history url and
     * gets user's history
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser")
            );

            List<HistoryDto> historyList =
                    historyService.getHistory(currentUser.get().getUserId()
                    );
            LOGGER.info("Got user's history from database");
            request.setAttribute("historyList", historyList);
            request.getRequestDispatcher(JspUrl.SHOW_HISTORY).forward(request, response);
        } catch (RuntimeException e) {
            LOGGER.error("RuntimeException: " + e.getMessage());
            request.setAttribute("message", "Failed: couldn't get history");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /get-history url and
     * calls doPost method
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}