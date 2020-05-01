package com.epam.controller.booked_place;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.BookedPlaceDto;
import com.epam.dto.HistoryDto;
import com.epam.service.BookedPlaceService;
import com.epam.service.impl.BookedPlaceServiceImpl;
import com.epam.service.impl.HistoryServiceImpl;
import com.epam.service.impl.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "DeleteBookedPlacesServlet", urlPatterns = ServletUrl.DELETE_BOOKED_PLACES)
public class DeleteBookedPlacesServlet extends HttpServlet {
    private BookedPlaceService bookedPlaceService;

    /**
     * Initialize resources
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        bookedPlaceService = new BookedPlaceServiceImpl();
    }

    /**
     * Method processes POST request for /delete-booked-places url
     * and delete user's booked places
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<HistoryDto> userHistoryList = (ArrayList<HistoryDto>) request.getAttribute("userHistoryList");

            userHistoryList.stream()
                    .forEach(historyDto ->
                            bookedPlaceService.cancelBook(
                                    new BookedPlaceDto(
                                            historyDto.getWagonNumber(),
                                            historyDto.getPlaceNumber(),
                                            historyDto.getDepartureDate(),
                                            new TrainServiceImpl().getAvailableTrain(
                                                    historyDto.getFromStation(),
                                                    historyDto.getToStation())
                                                    .stream()
                                                    .filter(trainDto ->
                                                            trainDto.getDepartureTime()
                                                                    .compareTo(historyDto.getDepartureTime()) == 0)
                                                    .collect(Collectors.toList())
                                                    .get(0)
                                                    .getTrainId()
                                    )
                            ));
            request.getRequestDispatcher(ServletUrl.DELETE_ACCOUNT).forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("message",
                    "Failed: couldn't delete account. Your history and tickets is deleted");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /delete-booked-places url
     * and forward to /view/search-trains.jsp
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
