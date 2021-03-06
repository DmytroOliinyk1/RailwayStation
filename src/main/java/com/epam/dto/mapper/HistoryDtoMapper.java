package com.epam.dto.mapper;

import com.epam.controller.user.LoginServlet;
import com.epam.dto.HistoryDto;
import com.epam.dto.HistoryDto;
import com.epam.entity.Entity;
import com.epam.entity.History;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoryDtoMapper implements DtoMapper<HistoryDto> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HistoryDtoMapper.class);

    /**
     * Method converts Entity to HistoryDto.
     *
     * @param entity
     * @return object type of HistoryDto
     */
    @Override
    public HistoryDto fromDtoToEntity(Entity entity) {
        HistoryDto historyDto = new HistoryDto();
        History history = (History) entity;
        historyDto.setHistoryId(history.getId());
        historyDto.setTrainNumber(history.getTrainNumber());
        historyDto.setFromStation(history.getFromStation());
        historyDto.setToStation(history.getToStation());
        historyDto.setDepartureTime(history.getDepartureTime());
        historyDto.setArrivalTime(history.getArrivalTime());
        historyDto.setDepartureDate(history.getDepartureDate());
        historyDto.setWagonNumber(history.getWagonNumber());
        historyDto.setPlaceNumber(history.getPlaceNumber());
        historyDto.setPrice(history.getPrice());
        historyDto.setUserId(history.getUserId());
        LOGGER.info("Created HistoryDto from History");
        return historyDto;
    }
}