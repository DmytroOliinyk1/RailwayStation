package com.epam.dao.builder;

import com.epam.entity.BookedPlace;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookedPlaceBuilder implements InstanceBuilder<BookedPlace> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(BookedPlaceBuilder.class);

    /**
     * Method creates object type of BookedPlace from ResultSet.
     *
     * @param resultSet
     * @return object type of BookedPlace
     */
    @Override
    public BookedPlace createInstance(ResultSet resultSet) {
        BookedPlace bookedPlace = new BookedPlace();
        try {
            bookedPlace.setId(resultSet.getLong("BookedPlaceID"));
            bookedPlace.setWagonNumber(resultSet.getLong("WagonNumber"));
            bookedPlace.setPlaceNumber(resultSet.getLong("PlaceNumber"));
            bookedPlace.setDepartureDate(resultSet.getDate("DepartureDate"));
            bookedPlace.setTrainId(resultSet.getLong("TrainID"));
            LOGGER.info("Created BookedPlace from ResultSet");
            return bookedPlace;
        } catch (SQLException e) {
            LOGGER.error("SQLException: " + e.getMessage());
            throw new RuntimeException();
        }
    }
}