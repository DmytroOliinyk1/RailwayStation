package com.epam.dao;

import com.epam.dao.crud.DaoCrudA;
import com.epam.entity.BookedPlace;

public class BookedPlaceDao extends DaoCrudA<BookedPlace> {
    /**
     * Method gets fields of BookedPlace and
     * put them in array
     *
     * @param entity
     * @return array of fields
     */
    @Override
    protected Object[] getFields(BookedPlace entity) {
        Object[] fields = new Object[5];
        fields[0] = entity.getId();
        fields[1] = entity.getWagonNumber();
        fields[2] = entity.getPlaceNumber();
        fields[3] = entity.getDepartureDate();
        fields[4] = entity.getTrainId();
        return fields;
    }

    /**
     * Method puts sql queries in map
     */
    @Override
    protected void init() {
        for (BookedPlace.bookedPlaceSqlQuery bookedPlaceSqlQuery : BookedPlace.bookedPlaceSqlQuery.values()) {
            sqlQueries.put(bookedPlaceSqlQuery.getSqlQuery(), bookedPlaceSqlQuery);
        }
    }


}