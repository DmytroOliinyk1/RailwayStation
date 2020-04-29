package com.epam.dao.builder;

import java.sql.ResultSet;

public interface InstanceBuilder<TEntity> {
    TEntity createInstance(ResultSet resultSet);
}