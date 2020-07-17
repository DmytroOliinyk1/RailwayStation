package com.epam.service;

import com.epam.dto.BookedPlaceDto;

import java.sql.Date;
import java.util.List;

public interface BookedPlaceService {
    /**
     * Method gets list objects of type BookedPlaceDto
     * from database.
     *
     * @param bookedPlaceDto
     * @return list objects of type BookedPlaceDto
     */
    List<BookedPlaceDto> getDisabledPlaces(BookedPlaceDto bookedPlaceDto);

    /**
     * Method saves booked place in database.
     *
     * @param bookedPlaceDto
     * @return boolean result of saving
     */
    boolean saveBookedPlace(BookedPlaceDto bookedPlaceDto);

    /**
     * Method deletes booked place from database.
     *
     * @param bookedPlaceDto
     * @return boolean result of deleting
     */
    boolean cancelBook(BookedPlaceDto bookedPlaceDto);
}