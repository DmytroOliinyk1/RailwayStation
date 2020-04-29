package com.epam.dao.crud;

import com.epam.dao.builder.InstanceBuilder;
import com.epam.db.DBConnection;
import com.epam.entity.SqlQuery;
import com.epam.util.CrudUtils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DaoReadA<TEntity> implements DaoReadI<TEntity> {
    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    protected DaoReadA() {
        sqlQueries = new HashMap<>();
        init();
    }

    @Override
    public TEntity getById(InstanceBuilder<TEntity> builder, Long id) {
        Connection connection = DBConnection.getConnection();
        return CrudUtils.getEntity(connection, builder, sqlQueries.get(SqlQuery.GET_BY_ID).toString(), id).get();
    }

    @Override
    public List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields) {
        Connection connection = DBConnection.getConnection();
        return CrudUtils.getEntityList(connection, builder, sqlQueries.get(SqlQuery.GET_BY_FIELD).toString(), fields);
    }

    @Override
    public List<TEntity> getAll(InstanceBuilder<TEntity> builder, Object... params) {
        Connection connection = DBConnection.getConnection();
        return CrudUtils.getEntityList(connection, builder, sqlQueries.get(SqlQuery.GET_ALL).toString(), params);
    }

    protected abstract void init();
}