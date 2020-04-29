package com.epam.service.impl;

import com.epam.dao.HistoryDao;
import com.epam.dao.builder.HistoryBuilder;
import com.epam.dto.BookedPlaceDto;
import com.epam.dto.HistoryDto;
import com.epam.dto.TrainDto;
import com.epam.dto.mapper.HistoryDtoMapper;
import com.epam.entity.History;
import com.epam.service.HistoryService;

import java.util.List;
import java.util.stream.Collectors;

public class HistoryServiceImpl implements HistoryService {
    private HistoryDao historyDao;

    public HistoryServiceImpl() {
        historyDao = new HistoryDao();
    }

    /**
     * Method save booked ticket in database
     *
     * @param bookedPlaceDto
     * @param trainDto
     * @param userId
     * @return boolean result of saving
     */
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

    /**
     * Method gets list objects of type HistoryDto
     *
     * @param userId
     * @return list objects of type HistoryDto
     */
    @Override
    public List<HistoryDto> getHistory(Long userId) {
        return historyDao.getByFields(new HistoryBuilder(), userId)
                .stream()
                .map(new HistoryDtoMapper()::fromDtoToEntity)
                .collect(Collectors.toList());
    }
}