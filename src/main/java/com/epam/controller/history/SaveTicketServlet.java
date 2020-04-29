package com.epam.controller.history;

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

@WebServlet(name = "SaveTicketServlet", urlPatterns = "/save-ticket")
public class SaveTicketServlet extends HttpServlet {
    private HistoryService historyService;

    @Override
    public void init() throws ServletException {
        historyService = new HistoryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            request.getRequestDispatcher("/get-history").forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute(
                    "currentBookedPlace", request.getAttribute("currentBookedPlace"));
            request.getRequestDispatcher("/cancel-book").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/search").forward(request, response);
    }
}