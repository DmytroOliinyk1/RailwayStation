package com.epam.controller.booked_place;

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

@WebServlet(name = "CancelBookServlet", urlPatterns = "/cancel-book")
public class CancelBookServlet extends HttpServlet {
    BookedPlaceService bookedPlaceService;

    @Override
    public void init() throws ServletException {
        bookedPlaceService = new BookedPlaceServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Optional<BookedPlaceDto> currentBookedPlace = Optional.of(
                    (BookedPlaceDto) request.getAttribute("currentBookedPlace"));
            bookedPlaceService.cancelBook(currentBookedPlace.get());
            request.setAttribute("message", "Failed: something was wrong");
        } catch (RuntimeException e){
            request.setAttribute("message", "Failed: ticket is not purchased");
            request.getRequestDispatcher("/search-trains").forward(request, response);
        } finally {
            request.getRequestDispatcher("/search").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/search").forward(request, response);
    }
}
