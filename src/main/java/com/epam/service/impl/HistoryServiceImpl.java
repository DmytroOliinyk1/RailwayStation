package com.epam.service.impl;

import com.epam.dao.HistoryDao;
import com.epam.dto.BookedPlaceDto;
import com.epam.dto.TrainDto;
import com.epam.entity.History;
import com.epam.service.HistoryService;

public class HistoryServiceImpl implements HistoryService {
    private HistoryDao historyDao;

    public HistoryServiceImpl() {
        historyDao = new HistoryDao();
    }

    @Override
    public boolean saveTicket(BookedPlaceDto bookedPlaceDto, TrainDto trainDto, Long userId) {
        return historyDao.insert(new History(
                        trainDto.getTrainNumber(), trainDto.getFromStation(),
                        trainDto.getToStation(), trainDto.getDepartureTime(),
                        trainDto.getArrivalTime(), bookedPlaceDto.getDepartureDate(),
                        bookedPlaceDto.getWagonNumber(), bookedPlaceDto.getPlaceNumber(),
                        trainDto.getPrice(), userId
                )
        );
    }
}