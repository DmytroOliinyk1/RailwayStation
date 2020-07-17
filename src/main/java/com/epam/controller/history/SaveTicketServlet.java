package com.epam.controller.history;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.controller.user.LoginServlet;
import com.epam.dto.BookedPlaceDto;
import com.epam.dto.TrainDto;
import com.epam.dto.UserDto;
import com.epam.service.HistoryService;
import com.epam.service.impl.HistoryServiceImpl;

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
 * Servlet is used for saving user`s tickets.
 */
@WebServlet(name = "SaveTicketServlet", urlPatterns = ServletUrl.SAVE_TICKETS)
public class SaveTicketServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveTicketServlet.class);

    private HistoryService historyService;

    /**
     * Method initializes resources.
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        historyService = new HistoryServiceImpl();
    }

    /**
     * Method processes POST request for /save-ticket url and
     * saves user's ticket.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Optional<BookedPlaceDto> currentBookedPlace =
                    Optional.of((BookedPlaceDto) request.getAttribute("currentBookedPlace"));

            Optional<TrainDto> currentTrain =
                    Optional.of((TrainDto) request.getSession().getAttribute("currentTrain"));

            Optional<UserDto> currentUser =
                    Optional.of((UserDto) request.getSession().getAttribute("currentUser"));

            historyService.saveTicket(
                    currentBookedPlace.get(), currentTrain.get(), currentUser.get().getUserId()
            );
            LOGGER.info("Saved user's history in database");
            request.getRequestDispatcher(ServletUrl.GET_HISTORY).forward(request, response);
        } catch (RuntimeException e) {
            LOGGER.error("RuntimeException: " + e.getMessage());
            request.setAttribute(
                    "currentBookedPlace", request.getAttribute("currentBookedPlace"));
            request.getRequestDispatcher(ServletUrl.CANCEL_BOOK).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /save-ticket url and
     * forwards to /view/search-trains.jsp.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
    }
}