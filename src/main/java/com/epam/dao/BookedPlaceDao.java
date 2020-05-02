package com.epam.dao;

import com.epam.controller.user.LoginServlet;
import com.epam.dao.crud.DaoCrudA;
import com.epam.entity.BookedPlace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookedPlaceDao extends DaoCrudA<BookedPlace> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookedPlaceDao.class);

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
        LOGGER.info("Put BookedPlace's sqlQueries in Map sqlQueries");
    }


}