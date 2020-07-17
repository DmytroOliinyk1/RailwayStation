package com.epam.dao.builder;

import com.epam.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserBuilder implements InstanceBuilder<User> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserBuilder.class);

    /**
     * Method creates object type of User from ResultSet.
     *
     * @param resultSet
     * @return object type of User
     */
    @Override
    public User createInstance(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("UserID"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            user.setName(resultSet.getString("Name"));
            user.setSurname(resultSet.getString("Surname"));
            LOGGER.info("Created User from ResultSet");
            return user;
        } catch (SQLException e) {
            LOGGER.error("SQLException: " + e.getMessage());
            throw new RuntimeException();
        }
    }
}
