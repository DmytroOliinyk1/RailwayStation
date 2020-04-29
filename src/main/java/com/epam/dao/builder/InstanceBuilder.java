package com.epam.dao.builder;

import java.sql.ResultSet;

public interface InstanceBuilder<TEntity> {
    /**
     * Method creates object type of TEntity from ResultSet
     *
     * @param resultSet
     * @return object type of TEntity
     */
    TEntity createInstance(ResultSet resultSet);
}