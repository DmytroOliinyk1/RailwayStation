package com.epam.dao;

import com.epam.controller.user.LoginServlet;
import com.epam.dao.crud.DaoCrudA;
import com.epam.entity.History;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoryDao extends DaoCrudA<History> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HistoryDao.class);

    /**
     * Method gets fields of History and
     * put them in array
     *
     * @param entity
     * @return array of fields
     */
    @Override
    protected Object[] getFields(History entity) {
        Object[] fields = new Object[11];
        fields[0] = entity.getId();
        fields[1] = entity.getTrainNumber();
        fields[2] = entity.getFromStation();
        fields[3] = entity.getToStation();
        fields[4] = entity.getDepartureTime();
        fields[5] = entity.getArrivalTime();
        fields[6] = entity.getDepartureDate();
        fields[7] = entity.getWagonNumber();
        fields[8] = entity.getPlaceNumber();
        fields[9] = entity.getPrice();
        fields[10] = entity.getUserId();
        return fields;
    }

    /**
     * Method puts sql queries in map
     */
    @Override
    protected void init() {
        for (History.historySqlQuery historySqlQuery : History.historySqlQuery.values()) {
            sqlQueries.put(historySqlQuery.getSqlQuery(), historySqlQuery);
        }
        LOGGER.info("Put History's sqlQueries in Map sqlQueries");
    }
}