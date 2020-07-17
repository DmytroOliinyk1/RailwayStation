package com.epam.dao.builder;

import com.epam.entity.History;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoryBuilder implements InstanceBuilder<History> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HistoryBuilder.class);

    /**
     * Method creates object type of History from ResultSet.
     *
     * @param resultSet
     * @return object type of History
     */
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
            LOGGER.info("Created History from ResultSet");
            return history;
        } catch (SQLException e) {
            LOGGER.error("SQLException: " + e.getMessage());
            throw new RuntimeException();
        }
    }
}