package com.epam.controller.booked_place;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.BookedPlaceDto;
import com.epam.dto.TrainDto;
import com.epam.dto.UserDto;
import com.epam.exception.NotFoundException;
import com.epam.service.BookedPlaceService;
import com.epam.service.impl.BookedPlaceServiceImpl;
import com.epam.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet is used for buying tickets on trains.
 */
@WebServlet(name = "BuyTicketServlet", urlPatterns = ServletUrl.BUY_TICKETS)
public class BuyTicketServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyTicketServlet.class);

    private BookedPlaceService bookedPlaceService;

    /**
     * Method initializes resources.
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        bookedPlaceService = new BookedPlaceServiceImpl();
    }

    /**
     * Method processes POST request for /buy-ticket url and
     * saves booked place.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Optional<UserDto> userDto = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser")
            );

            Optional<TrainDto> trainDto = Optional.of(
                    (TrainDto) request.getSession().getAttribute("currentTrain"));

            Long wagonNumber = Long.valueOf(request.getParameter("wagonNumber"));

            Long placeNumber = Long.valueOf(request.getParameter("placeNumber"));

            String date = request.getParameter("departureDate");

            Date departureDate = new Date(
                    new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());

            if (DateUtils.compareDateAndTime(departureDate, trainDto.get().getDepartureTime())) {
                throw new RuntimeException("Train has already departed. Couldn't buy ticket");
            }

            BookedPlaceDto bookedPlaceDto = new BookedPlaceDto(
                    wagonNumber, placeNumber, departureDate, trainDto.get().getTrainId());

            if (bookedPlaceService.getDisabledPlaces(bookedPlaceDto).isEmpty()) {
                bookedPlaceService.saveBookedPlace(bookedPlaceDto);
                LOGGER.info("Saved booked place in database");
                request.setAttribute("currentBookedPlace", bookedPlaceDto);
                request.getRequestDispatcher(ServletUrl.SAVE_TICKETS).forward(request, response);
            } else {
                throw new NotFoundException("Place is already occupied");
            }

        } catch (ParseException e) {
            LOGGER.error("ParseException: " + e.getMessage());
            request.setAttribute("message", "Failed: incorrect date");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException: " + e.getMessage());
            request.setAttribute("message", "Failed: incorrect place or wagon number");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        } catch (RuntimeException e) {
            LOGGER.error("RuntimeException: " + e.getMessage());
            request.setAttribute("message", "Failed: ticket is not purchased");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }


    /**
     * Method processes GET request for /buy-ticket url and
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
