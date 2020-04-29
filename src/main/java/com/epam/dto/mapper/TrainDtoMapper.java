package com.epam.dto.mapper;

import com.epam.dto.TrainDto;
import com.epam.entity.Entity;
import com.epam.entity.Train;

public class TrainDtoMapper implements DtoMapper<TrainDto> {
    /**
     * Method converts Entity to TrainDto
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
        return trainDto;
    }
}