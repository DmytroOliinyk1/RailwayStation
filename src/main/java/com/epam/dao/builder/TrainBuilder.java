package com.epam.dao.builder;

import com.epam.dao.builder.InstanceBuilder;
import com.epam.entity.Train;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainBuilder implements InstanceBuilder<Train> {
    /**
     * Method creates object type of Train from ResultSet
     *
     * @param resultSet
     * @return object type of Train
     */
    @Override
    public Train createInstance(ResultSet resultSet) {
        Train train = new Train();
        try {
            train.setId(resultSet.getLong("TrainID"));
            train.setTrainNumber(resultSet.getString("TrainNumber"));
            train.setFromStation(resultSet.getString("FromStation"));
            train.setToStation(resultSet.getString("ToStation"));
            train.setDepartureTime(resultSet.getTime("DepartureTime"));
            train.setArrivalTime(resultSet.getTime("ArrivalTime"));
            train.setWagonsQuantity(resultSet.getLong("WagonsQuantity"));
            train.setPlacesQuantity(resultSet.getLong("PlacesQuantity"));
            train.setPrice(resultSet.getBigDecimal("Price"));
            return train;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}