package com.epam.service.impl;

import com.epam.dao.BookedPlaceDao;
import com.epam.dao.builder.BookedPlaceBuilder;
import com.epam.dto.BookedPlaceDto;
import com.epam.dto.mapper.BookedPlaceDtoMapper;
import com.epam.entity.BookedPlace;
import com.epam.service.BookedPlaceService;

import java.util.List;
import java.util.stream.Collectors;

public class BookedPlaceServiceImpl implements BookedPlaceService {
    private BookedPlaceDao bookedPlaceDao;

    public BookedPlaceServiceImpl() {
        bookedPlaceDao = new BookedPlaceDao();
    }

    @Override
    public List<BookedPlaceDto> getDisabledPlaces(BookedPlaceDto bookedPlaceDto) {
        return bookedPlaceDao.getByFields(
                new BookedPlaceBuilder(), bookedPlaceDto.getTrainId(), bookedPlaceDto.getDepartureDate(),
                bookedPlaceDto.getWagonNumber(), bookedPlaceDto.getPlaceNumber())
                .stream()
                .map(new BookedPlaceDtoMapper()::fromDtoToEntity)
                .collect(Collectors.toList()
                );
    }

    @Override
    public boolean saveBookedPlace(BookedPlaceDto bookedPlaceDto) {
        return bookedPlaceDao.insert(
                new BookedPlace(
                        bookedPlaceDto.getWagonNumber(), bookedPlaceDto.getPlaceNumber(),
                        bookedPlaceDto.getDepartureDate(), bookedPlaceDto.getTrainId())
        );
    }
}