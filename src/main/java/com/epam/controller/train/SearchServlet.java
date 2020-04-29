package com.epam.controller.train;

import com.epam.dto.TrainDto;
import com.epam.service.TrainService;
import com.epam.service.impl.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    TrainService trainService;

    @Override
    public void init() throws ServletException {
        trainService = new TrainServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<TrainDto> trainDtoList = trainService.getAvailableTrain(
                    request.getParameter("fromStation"), request.getParameter("toStation")
            );
            if(!trainDtoList.isEmpty()){
                request.setAttribute("trainList", trainDtoList);
                request.getRequestDispatcher("/view/available-trains.jsp").forward(request, response);
            } else {
                throw new RuntimeException();
            }

        } catch (RuntimeException e) {
            request.setAttribute("message", "No available trains");
            request.getRequestDispatcher("/view/search-trains.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/search-trains.jsp").forward(request, response);
    }
}
