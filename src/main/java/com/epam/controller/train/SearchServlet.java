package com.epam.controller.train;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.controller.user.LoginServlet;
import com.epam.dto.TrainDto;
import com.epam.exception.NotFoundException;
import com.epam.service.TrainService;
import com.epam.service.impl.TrainServiceImpl;
import com.epam.util.TrainSearchUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "SearchServlet", urlPatterns = ServletUrl.SEARCH_TRAINS)
public class SearchServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchServlet.class);

    TrainService trainService;

    /**
     * Method initializes resources
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        trainService = new TrainServiceImpl();
    }

    /**
     * Method processes POST request for /search-trains url and
     * searches trains with input route
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (TrainSearchUtils.checkRoute(
                    request.getParameter("fromStation"), request.getParameter("toStation"))
            ) {
                List<TrainDto> trainDtoList = trainService.getAvailableTrain(
                        request.getParameter("fromStation"), request.getParameter("toStation")
                );
                if (!trainDtoList.isEmpty()) {
                    LOGGER.info("Got available trains from database");
                    request.setAttribute("trainList", trainDtoList);
                    request.getRequestDispatcher(JspUrl.AVAILABLE_TRAINS).forward(request, response);
                } else {
                    throw new NotFoundException("No available trains");
                }
            } else {
                LOGGER.warn("Empty input field");
                request.setAttribute("message", "Empty field");
                request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
            }
        } catch (RuntimeException e) {
            LOGGER.error("RuntimeException: " + e.getMessage());
            request.setAttribute("message", "No available trains");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /search-trains url and
     * forwards to /view/search-trains.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
    }
}
