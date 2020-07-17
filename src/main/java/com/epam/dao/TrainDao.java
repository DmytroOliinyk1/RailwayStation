package com.epam.dao;

import com.epam.dao.crud.DaoCrudA;
import com.epam.entity.Train;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainDao extends DaoCrudA<Train> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(TrainDao.class);

    /**
     * Method gets fields of Train and
     * put them in array
     *
     * @param entity
     * @return array of fields
     */
    @Override
    protected Object[] getFields(Train entity) {
        final int NUMBER_OF_FIELDS_IN_ENTITY = 9;
        Object[] fields = new Object[NUMBER_OF_FIELDS_IN_ENTITY];
        fields[0] = entity.getId();
        fields[1] = entity.getTrainNumber();
        fields[2] = entity.getFromStation();
        fields[3] = entity.getToStation();
        fields[4] = entity.getDepartureTime();
        fields[5] = entity.getArrivalTime();
        fields[6] = entity.getWagonsQuantity();
        fields[7] = entity.getPlacesQuantity();
        fields[8] = entity.getPrice();
        return fields;
    }

    /**
     * Method puts sql queries in map
     */
    @Override
    protected void init() {
        for (Train.trainSqlQuery trainSqlQuery : Train.trainSqlQuery.values()) {
            sqlQueries.put(trainSqlQuery.getSqlQuery(), trainSqlQuery);
        }
        LOGGER.info("Put Train's sqlQueries in Map sqlQueries");
    }
}