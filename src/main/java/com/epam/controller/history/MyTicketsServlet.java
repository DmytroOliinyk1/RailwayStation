package com.epam.controller.history;

import com.epam.dto.HistoryDto;
import com.epam.dto.UserDto;
import com.epam.service.HistoryService;
import com.epam.service.impl.HistoryServiceImpl;
import com.epam.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "MyTicketsServlet", urlPatterns = "/my-tickets")
public class MyTicketsServlet extends HttpServlet {
    private HistoryService historyService;

    @Override
    public void init() throws ServletException {
        historyService = new HistoryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto)request.getSession().getAttribute("currentUser")
            );

            List<HistoryDto> myTicketsList = historyService
                    .getHistory(currentUser.get().getUserId())
                    .stream()
                    .filter(historyDto ->
                            historyDto.getDepartureDate().compareTo(DateUtils.currentDateMinusDay()) >= 0)
                    .collect(Collectors.toList());

            request.setAttribute("myTicketsList", myTicketsList);
            request.getRequestDispatcher("/view/my-tickets.jsp").forward(request, response);
        } catch (RuntimeException e){
            request.setAttribute("message", "Some trouble");
        }
    }
}
