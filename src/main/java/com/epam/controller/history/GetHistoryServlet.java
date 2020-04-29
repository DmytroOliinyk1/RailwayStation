package com.epam.controller.history;

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

@WebServlet(name = "GetHistoryServlet", urlPatterns = "/get-history")
public class GetHistoryServlet extends HttpServlet {
    HistoryService historyService;

    @Override
    public void init() throws ServletException {
        historyService = new HistoryServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser")
            );

            List<HistoryDto> historyList =
                    historyService.getHistory(currentUser.get().getUserId()
                    );
            request.setAttribute("historyList", historyList);
            request.getRequestDispatcher("/view/show-history.jsp").forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("message", "Failed: some trouble");
            request.getRequestDispatcher("/view/search-trains.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}