package com.epam.controller.history;

import com.epam.constants.jsp_url.JspUrl;
import com.epam.constants.servlet_url.ServletUrl;
import com.epam.dto.HistoryDto;
import com.epam.dto.UserDto;
import com.epam.entity.History;
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

@WebServlet(name = "DeleteHistoryServlet", urlPatterns = "/delete-history")
public class DeleteHistoryServlet extends HttpServlet {
    private HistoryService historyService;

    /**
     * Initialize resources
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        historyService = new HistoryServiceImpl();
    }

    /**
     * Method processes POST request for /delete-history url
     * and delete user's history
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

            List<HistoryDto> userHistoryList = historyService.getHistory(currentUser.get().getUserId());
            request.setAttribute("userHistoryList", userHistoryList);

            historyService.delete(currentUser.get().getUserId());
            System.out.println("user history deleted");
            request.getRequestDispatcher("/delete-booked-places").forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("message", "Failed: couldn't delete account. History is deleted");
            request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
        }
    }

    /**
     * Method processes GET request for /delete-history url
     * and forward to /view/search-trains.jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JspUrl.SEARCH_TRAINS).forward(request, response);
    }
}
