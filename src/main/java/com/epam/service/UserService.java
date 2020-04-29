package com.epam.service;

import com.epam.dao.builder.UserBuilder;
import com.epam.dto.UserDto;
import com.epam.entity.User;

public interface UserService {
    /**
     * Method checks if user exist
     *
     * @param email
     * @param password
     * @return object of type UserDto
     */
    UserDto login(String email, String password);

    /**
     * Method changes account password
     *
     * @param email
     * @param newPassword
     * @return boolean result of changing
     */
    boolean changePassword(String email, String newPassword);

    /**
     * Method saves new user in database
     *
     * @param userDto
     * @return boolean result of saving
     */
    boolean save(UserDto userDto);

    /**
     * Method deletes user from database
     *
     * @param id
     * @return boolean result of deleting
     */
    boolean deleteUser(Long id);
}