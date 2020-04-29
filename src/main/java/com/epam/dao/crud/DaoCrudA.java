package com.epam.dao.crud;

import com.epam.db.DBConnection;
import com.epam.entity.Entity;
import com.epam.entity.SqlQuery;
import com.epam.util.CrudUtils;

import java.sql.Connection;
import java.util.Arrays;

public abstract class DaoCrudA<TEntity extends Entity> extends DaoReadA<TEntity> implements DaoCrudI<TEntity> {

    private final int BEGIN_RANGE_WITHOUT_ID = 1;

    protected DaoCrudA() {
        super();
    }

    protected abstract Object[] getFields(TEntity entity);

    @Override
    public boolean insert(TEntity object) {
        Connection connection = DBConnection.getConnection();
        int status = CrudUtils.update(
                connection, sqlQueries.get(SqlQuery.INSERT).toString(),
                Arrays.copyOfRange(getFields(object), BEGIN_RANGE_WITHOUT_ID, getFields(object).length));
        return status == 1;
    }

    @Override
    public boolean updateById(Object... args) {
        Connection connection = DBConnection.getConnection();
        int status = CrudUtils.update(
                connection, sqlQueries.get(SqlQuery.UPDATE_BY_ID).toString(), args
        );
        return status > 0;
    }

    @Override
    public boolean updateByFields(Object... fieldsValues) {
        Connection connection = DBConnection.getConnection();
        int status = CrudUtils.update(
                connection, sqlQueries.get(SqlQuery.UPDATE_BY_FIELD).toString(), fieldsValues);
        return status > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = DBConnection.getConnection();
        int status = CrudUtils.update(
                connection, sqlQueries.get(SqlQuery.DELETE_BY_ID).toString(), id
        );
        return status == 1;
    }

    @Override
    public boolean deleteByFields(Object... fieldsValues) {
        Connection connection = DBConnection.getConnection();
        int status = CrudUtils.update(
                connection, sqlQueries.get(SqlQuery.DELETE_BY_FIELD).toString(), fieldsValues
        );
        return status > 0;
    }
}