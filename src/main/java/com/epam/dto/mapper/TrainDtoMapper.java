package com.epam.dto.mapper;

import com.epam.controller.user.LoginServlet;
import com.epam.dto.TrainDto;
import com.epam.entity.Entity;
import com.epam.entity.Train;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainDtoMapper implements DtoMapper<TrainDto> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(TrainDtoMapper.class);

    /**
     * Method converts Entity to TrainDto.
     *
     * @param entity
     * @return object type of TrainDto
     */
    @Override
    public TrainDto fromDtoToEntity(Entity entity) {
        TrainDto trainDto = new TrainDto();
        Train train = (Train) entity;
        trainDto.setTrainId(train.getId());
        trainDto.setTrainNumber(train.getTrainNumber());
        trainDto.setFromStation(train.getFromStation());
        trainDto.setToStation(train.getToStation());
        trainDto.setDepartureTime(train.getDepartureTime());
        trainDto.setArrivalTime(train.getArrivalTime());
        trainDto.setWagonsQuantity(train.getWagonsQuantity());
        trainDto.setPlacesQuantity(train.getPlacesQuantity());
        trainDto.setPrice(train.getPrice());
        LOGGER.info("Created TrainDto from Train");
        return trainDto;
    }
}