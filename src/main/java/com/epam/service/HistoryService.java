package com.epam.service;

import com.epam.dto.BookedPlaceDto;
import com.epam.dto.TrainDto;

public interface HistoryService {
    boolean saveTicket(BookedPlaceDto bookedPlaceDto, TrainDto trainDto, Long userId);
}