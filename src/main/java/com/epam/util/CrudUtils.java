package com.epam.util;

import com.epam.dao.builder.InstanceBuilder;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudUtils {
    /**
     * Method gets object of type TEntity
     * from database
     *
     * @param connection
     * @param builder
     * @param sqlQuery
     * @param args
     * @param <TEntity>
     * @return optional object
     */
    public static <TEntity> Optional<TEntity> getEntity(
            Connection connection, InstanceBuilder<TEntity> builder, String sqlQuery, Object... args) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            setArgsToStatement(preparedStatement, args);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(builder.createInstance(resultSet));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Method gets list objects of type TEntity
     * from database
     *
     * @param connection
     * @param builder
     * @param sqlQuery
     * @param args
     * @param <TEntity>
     * @return list of TEntity object
     */
    public static <TEntity> List<TEntity> getEntityList(
            Connection connection, InstanceBuilder<TEntity> builder, String sqlQuery, Object... args) {
        List<TEntity> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            setArgsToStatement(preparedStatement, args);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    entityList.add(builder.createInstance(resultSet));
                }
                return entityList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Method inserts/updates/deletes objects
     * in database
     *
     * @param connection
     * @param sqlQuery
     * @param args
     * @return number of changed objects in database
     */
    public static int update(Connection connection, String sqlQuery, Object... args) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            setArgsToStatement(preparedStatement, args);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Method sets arguments in prepared statement
     *
     * @param preparedStatement
     * @param args
     */
    private static void setArgsToStatement(PreparedStatement preparedStatement, Object... args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    preparedStatement.setNull(i + 1, Types.NULL);
                } else if (args[i].getClass().equals(String.class)) {
                    preparedStatement.setString(i + 1, (String) args[i]);
                } else if (args[i].getClass().equals(Long.class)) {
                    preparedStatement.setLong(i + 1, (Long) args[i]);
                } else if (args[i].getClass().equals(Date.class)) {
                    preparedStatement.setDate(i + 1, (Date) args[i]);
                } else if (args[i].getClass().equals(Time.class)) {
                    preparedStatement.setTime(i + 1, (Time) args[i]);
                } else if (args[i].getClass().equals(BigDecimal.class)) {
                    preparedStatement.setBigDecimal(i + 1, (BigDecimal) args[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}