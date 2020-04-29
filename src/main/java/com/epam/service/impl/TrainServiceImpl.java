package com.epam.service.impl;

import com.epam.dao.TrainDao;
import com.epam.dao.builder.TrainBuilder;
import com.epam.dto.TrainDto;
import com.epam.dto.mapper.TrainDtoMapper;
import com.epam.service.TrainService;

import java.util.List;
import java.util.stream.Collectors;

public class TrainServiceImpl implements TrainService {

    private TrainDao trainDao;

    public TrainServiceImpl() {
        trainDao = new TrainDao();
    }

    @Override
    public List<TrainDto> getAvailableTrain(String fromStation, String toStation) {
        return trainDao.getByFields(new TrainBuilder(), fromStation, toStation)
                .stream()
                .map(new TrainDtoMapper()::fromDtoToEntity)
                .collect(Collectors.toList());
    }
}