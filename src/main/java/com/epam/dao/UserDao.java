package com.epam.dao;

import com.epam.dao.crud.DaoCrudA;
import com.epam.entity.User;

public class UserDao extends DaoCrudA<User> {
    @Override
    protected Object[] getFields(User entity) {
        Object[] fields = new Object[5];
        fields[0] = entity.getId();
        fields[1] = entity.getEmail();
        fields[2] = entity.getPassword();
        fields[3] = entity.getName();
        fields[4] = entity.getSurname();
        return fields;
    }

    @Override
    protected void init() {
        for(User.userSqlQuery userSqlQuery : User.userSqlQuery.values()){
            sqlQueries.put(userSqlQuery.getSqlQuery(), userSqlQuery);
        }
    }
}