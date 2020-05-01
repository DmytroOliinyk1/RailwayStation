package com.epam.controller.history;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "MyTicketsServlet", urlPatterns = ServletUrl.MY_TICKETS)
public class MyTicketsServlet extends HttpServlet {
    private HistoryService historyService;

    /**
     * Method initializes resources
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        historyService = new HistoryServiceImpl();
    }

    /**
     * Method processes POST request for /my-tickets url
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Method processes GET request for /my-tickets url and
     * gets user's tickets
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

            List<HistoryDto> myTicketsList = historyService
                    .getHistory(currentUser.get().getUserId())
                    .stream()
                    .filter(historyDto ->
                            historyDto.getDepartureDate().compareTo(DateUtils.currentDateMinusDay()) >= 0)
                    .collect(Collectors.toList());

            request.setAttribute("myTicketsList", myTicketsList);
            request.getRequestDispatcher(JspUrl.MY_TICKETS).forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("message", "Failed: couldn't get history");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }
}
