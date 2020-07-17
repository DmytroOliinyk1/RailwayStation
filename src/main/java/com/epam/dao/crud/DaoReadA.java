package com.epam.dao.crud;

import com.epam.controller.user.LoginServlet;
import com.epam.dao.builder.InstanceBuilder;
import com.epam.db.DBConnection;
import com.epam.entity.SqlQuery;
import com.epam.exception.NotFoundException;
import com.epam.util.CrudUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DaoReadA<TEntity> implements DaoReadI<TEntity> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DaoReadA.class);

    /**
     * Map stores sql queries.
     */
    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    /**
     * Default constructor
     */
    protected DaoReadA() {
        sqlQueries = new HashMap<>();
        init();
    }

    /**
     * Method gets object type of TEntity from database
     * by id.
     *
     * @param builder
     * @param id
     * @return object type of TEntity
     */
    @Override
    public TEntity getById(InstanceBuilder<TEntity> builder, Long id) {
        try (Connection connection = DBConnection.getConnection()) {
            return CrudUtils.getEntity(connection, builder, sqlQueries.get(SqlQuery.GET_BY_ID).toString(), id).get();
        } catch (SQLException e) {
            LOGGER.error("SQLException: " + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }

    /**
     * Method gets object type of TEntity from database
     * by fields.
     *
     * @param builder
     * @param fields
     * @return list objects type of TEntity
     */
    @Override
    public List<TEntity> getByFields(InstanceBuilder<TEntity> builder, Object... fields) {
        try (Connection connection = DBConnection.getConnection()) {
            return CrudUtils.getEntityList(
                    connection, builder, sqlQueries.get(SqlQuery.GET_BY_FIELD).toString(), fields);
        } catch (SQLException e) {
            LOGGER.error("SQLException: " + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }

    /**
     * Method gets list objects type of TEntity from database
     * by parameters.
     *
     * @param builder
     * @param params
     * @return list objects type of TEntity
     */
    @Override
    public List<TEntity> getAll(InstanceBuilder<TEntity> builder, Object... params) {
        try (Connection connection = DBConnection.getConnection()) {
            return CrudUtils.getEntityList(
                    connection, builder, sqlQueries.get(SqlQuery.GET_ALL).toString(), params);
        } catch (SQLException e) {
            LOGGER.error("SQLException: " + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }

    /**
     * Method initializes query resources.
     */
    protected abstract void init();
}
