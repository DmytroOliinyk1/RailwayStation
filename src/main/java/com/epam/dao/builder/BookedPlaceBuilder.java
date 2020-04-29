package com.epam.dao.builder;

import com.epam.entity.BookedPlace;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookedPlaceBuilder implements InstanceBuilder<BookedPlace> {
    @Override
    public BookedPlace createInstance(ResultSet resultSet) {
        BookedPlace bookedPlace = new BookedPlace();
        try {
            bookedPlace.setId(resultSet.getLong("BookedPlaceID"));
            bookedPlace.setWagonNumber(resultSet.getLong("WagonNumber"));
            bookedPlace.setPlaceNumber(resultSet.getLong("PlaceNumber"));
            bookedPlace.setDepartureDate(resultSet.getDate("DepartureDate"));
            bookedPlace.setTrainId(resultSet.getLong("TrainID"));
            return bookedPlace;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}