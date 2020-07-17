package com.epam.service;

import com.epam.dto.TrainDto;

import java.util.List;

public interface TrainService {
    /**
     * Method gets list of trains from database.
     *
     * @param fromStation
     * @param toStation
     * @return list objects of type trainDto
     */
    List<TrainDto> getAvailableTrain(String fromStation, String toStation);

    /**
     * Method gets train from database.
     *
     * @param id
     * @return object of type TrainDto
     */
    TrainDto getTrain(Long id);

}
