package com.epam.service;

import com.epam.dto.BookedPlaceDto;
import com.epam.dto.HistoryDto;
import com.epam.dto.TrainDto;

import java.util.List;

public interface HistoryService {
    /**
     * Method save booked ticket in database.
     *
     * @param bookedPlaceDto
     * @param trainDto
     * @param userId
     * @return boolean result of saving
     */
    boolean saveTicket(BookedPlaceDto bookedPlaceDto, TrainDto trainDto, Long userId);

    /**
     * Method gets list objects of type HistoryDto.
     *
     * @param userId
     * @return list objects of type HistoryDto
     */
    List<HistoryDto> getHistory(Long userId);

    boolean delete(Long userId);
}