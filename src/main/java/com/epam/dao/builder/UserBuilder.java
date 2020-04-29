package com.epam.dao.builder;

import com.epam.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements InstanceBuilder<User> {
    /**
     * Method creates object type of User from ResultSet
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
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
