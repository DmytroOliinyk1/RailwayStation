package com.epam.dao;

import com.epam.dao.crud.DaoCrudA;
import com.epam.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao extends DaoCrudA<User> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserDao.class);

    /**
     * Method gets fields of User and
     * put them in array
     *
     * @param entity
     * @return array of fields
     */
    @Override
    protected Object[] getFields(User entity) {
        final int NUMBER_OF_FIELDS_IN_ENTITY = 5;
        Object[] fields = new Object[NUMBER_OF_FIELDS_IN_ENTITY];
        fields[0] = entity.getId();
        fields[1] = entity.getEmail();
        fields[2] = entity.getPassword();
        fields[3] = entity.getName();
        fields[4] = entity.getSurname();
        return fields;
    }

    /**
     * Method puts sql queries in map
     */
    @Override
    protected void init() {
        for (User.userSqlQuery userSqlQuery : User.userSqlQuery.values()) {
            sqlQueries.put(userSqlQuery.getSqlQuery(), userSqlQuery);
        }
        LOGGER.info("Put User's sqlQueries in Map sqlQueries");
    }
}