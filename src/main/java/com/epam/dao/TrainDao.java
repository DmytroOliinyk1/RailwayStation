package com.epam.dao;

import com.epam.dao.crud.DaoCrudA;
import com.epam.entity.Train;

public class TrainDao extends DaoCrudA<Train> {
    @Override
    protected Object[] getFields(Train entity) {
        Object[] fields = new Object[9];
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

    @Override
    protected void init() {
        for(Train.trainSqlQuery trainSqlQuery : Train.trainSqlQuery.values()){
            sqlQueries.put(trainSqlQuery.getSqlQuery(), trainSqlQuery);
        }
    }
}