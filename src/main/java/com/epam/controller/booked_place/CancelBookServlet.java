package com.epam.controller.booked_place;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.BookedPlaceDto;
import com.epam.service.BookedPlaceService;
import com.epam.service.impl.BookedPlaceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "CancelBookServlet", urlPatterns = ServletUrl.CANCEL_BOOK)
public class CancelBookServlet extends HttpServlet {
    BookedPlaceService bookedPlaceService;

    /**
     * Method initializes resources
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        bookedPlaceService = new BookedPlaceServiceImpl();
    }

    /**
     * Method processes POST request for /cancel-book url and
     * deletes booked place if happened trouble in /save-ticket servlet
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Optional<BookedPlaceDto> currentBookedPlace = Optional.of(
                    (BookedPlaceDto) request.getAttribute("currentBookedPlace"));
            bookedPlaceService.cancelBook(currentBookedPlace.get());
            request.setAttribute("message", "Failed: something was wrong while buying ticket");
        } catch (RuntimeException e) {

        } finally {
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /cancel-book url and
     * forwards to /view/search-trains
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
