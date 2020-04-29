package com.epam.dao.builder;

import com.epam.entity.History;
import com.epam.entity.Train;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryBuilder implements InstanceBuilder<History> {
    @Override
    public History createInstance(ResultSet resultSet) {
        History history = new History();
        try {
            history.setId(resultSet.getLong("HistoryID"));
            history.setTrainNumber(resultSet.getString("TrainNumber"));
            history.setFromStation(resultSet.getString("FromStation"));
            history.setToStation(resultSet.getString("ToStation"));
            history.setDepartureTime(resultSet.getTime("DepartureTime"));
            history.setArrivalTime(resultSet.getTime("ArrivalTime"));
            history.setDepartureDate(resultSet.getDate("DepartureDate"));
            history.setWagonNumber(resultSet.getLong("WagonNumber"));
            history.setPlaceNumber(resultSet.getLong("PlaceNumber"));
            history.setPrice(resultSet.getBigDecimal("Price"));
            history.setUserId(resultSet.getLong("UserID"));
            return history;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}