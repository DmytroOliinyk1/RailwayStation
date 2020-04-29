package com.epam.service;

import com.epam.dto.TrainDto;

import java.util.List;

public interface TrainService {
    List<TrainDto> getAvailableTrain(String fromStation, String toStation);

    TrainDto getTrain(Long id);

}
