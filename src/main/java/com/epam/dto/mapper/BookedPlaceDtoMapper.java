package com.epam.dto.mapper;

import com.epam.controller.user.LoginServlet;
import com.epam.dto.BookedPlaceDto;
import com.epam.entity.BookedPlace;
import com.epam.entity.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookedPlaceDtoMapper implements DtoMapper<BookedPlaceDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookedPlaceDtoMapper.class);

    /**
     * Method converts Entity to BookedPlaceDto
     *
     * @param entity
     * @return object type of BookedPlaceDto
     */
    @Override
    public BookedPlaceDto fromDtoToEntity(Entity entity) {
        BookedPlaceDto bookedPlaceDto = new BookedPlaceDto();
        BookedPlace bookedPlace = (BookedPlace) entity;
        bookedPlaceDto.setBookedPlaceId(bookedPlace.getId());
        bookedPlaceDto.setWagonNumber(bookedPlace.getWagonNumber());
        bookedPlaceDto.setPlaceNumber(bookedPlace.getPlaceNumber());
        bookedPlaceDto.setDepartureDate(bookedPlace.getDepartureDate());
        bookedPlaceDto.setTrainId(bookedPlace.getTrainId());
        LOGGER.info("Created BookedPlaceDto from BookedPlace");
        return bookedPlaceDto;
    }
}