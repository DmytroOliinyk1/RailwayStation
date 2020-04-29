package com.epam.controller.train;

import com.epam.dto.TrainDto;
import com.epam.dto.UserDto;
import com.epam.service.TrainService;
import com.epam.service.impl.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@WebServlet(name = "GetTrainServlet", urlPatterns = "/get-train")
public class GetTrainServlet extends HttpServlet {
    TrainService trainService;

    @Override
    public void init() throws ServletException {
        trainService = new TrainServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Optional<TrainDto> currentTrain = Optional.of(
                    trainService.getTrain(Long.valueOf(request.getParameter("trainId")))
            );

            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser")
            );

            request.getSession().setAttribute("currentTrain", currentTrain.get());
            request.setAttribute("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            request.setAttribute("currentDatePlusMonth",
                    new SimpleDateFormat("yyyy-MM-dd").format(currentDatePlusMonth()));

            request.getRequestDispatcher("/view/buy-ticket.jsp").forward(request, response);

        } catch (RuntimeException e) {
            request.setAttribute("message", "Train not found");
            request.getRequestDispatcher("/view/search-trains.jsp").forward(request, response);
        }
    }

    private Date currentDatePlusMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);
        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());
        return date;
    }
}
