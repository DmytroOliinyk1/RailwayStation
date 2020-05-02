package com.epam.controller.train;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.controller.user.LoginServlet;
import com.epam.dto.TrainDto;
import com.epam.dto.UserDto;
import com.epam.service.TrainService;
import com.epam.service.impl.TrainServiceImpl;
import com.epam.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "GetTrainServlet", urlPatterns = ServletUrl.GET_TRAIN)
public class GetTrainServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetTrainServlet.class);

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
     * Method processes POST request for /get-train url
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Method processes GET request for /get-train url and
     * gets train
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser")
            );

            Optional<TrainDto> currentTrain = Optional.of(
                    trainService.getTrain(Long.valueOf(request.getParameter("trainId")))
            );

            request.getSession().setAttribute("currentTrain", currentTrain.get());
            request.setAttribute("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            request.setAttribute("currentDatePlusMonth",
                    new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.currentDatePlusMonth()));
            LOGGER.info("Got train from database");
            request.getRequestDispatcher(JspUrl.BUY_TICKETS).forward(request, response);
        } catch (RuntimeException e) {
            LOGGER.error("RuntimeException: " + e.getMessage());
            request.setAttribute("message", "Train not found");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }
}
