package com.epam.controller.train;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.TrainDto;
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

@WebServlet(name = "SearchServlet", urlPatterns = ServletUrl.SEARCH_TRAINS)
public class SearchServlet extends HttpServlet {
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
                    request.setAttribute("trainList", trainDtoList);
                    request.getRequestDispatcher(JspUrl.AVAILABLE_TRAINS).forward(request, response);
                } else {
                    throw new RuntimeException();
                }
            } else {
                request.setAttribute("message", "Empty field");
                request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
            }
        } catch (RuntimeException e) {
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
