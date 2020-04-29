package com.epam.service;

import com.epam.dto.BookedPlaceDto;

import java.sql.Date;
import java.util.List;

public interface BookedPlaceService {

    List<BookedPlaceDto> getDisabledPlaces(BookedPlaceDto bookedPlaceDto);

    boolean saveBookedPlace(BookedPlaceDto bookedPlaceDto);
}