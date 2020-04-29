package com.epam.service;

import com.epam.dto.BookedPlaceDto;
import com.epam.dto.HistoryDto;
import com.epam.dto.TrainDto;

import java.util.List;

public interface HistoryService {
    boolean saveTicket(BookedPlaceDto bookedPlaceDto, TrainDto trainDto, Long userId);

    List<HistoryDto> getHistory(Long userId);
}