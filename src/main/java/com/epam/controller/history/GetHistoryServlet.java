package com.epam.controller.history;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
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

@WebServlet(name = "GetHistoryServlet", urlPatterns = ServletUrl.GET_HISTORY)
public class GetHistoryServlet extends HttpServlet {
    HistoryService historyService;

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
     * Method processes POST request for /get-history url and
     * gets user's history
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Optional<UserDto> currentUser = Optional.of(
                    (UserDto) request.getSession().getAttribute("currentUser")
            );

            List<HistoryDto> historyList =
                    historyService.getHistory(currentUser.get().getUserId()
                    );
            request.setAttribute("historyList", historyList);
            request.getRequestDispatcher(JspUrl.SHOW_HISTORY).forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("message", "Failed: some trouble");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /get-history url and
     * calls doPost method
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}