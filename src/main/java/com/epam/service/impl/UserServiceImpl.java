package com.epam.service.impl;

import com.epam.dao.UserDao;
import com.epam.dao.builder.UserBuilder;
import com.epam.dto.UserDto;
import com.epam.dto.mapper.UserDtoMapper;
import com.epam.entity.User;
import com.epam.service.UserService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDao();
    }

    /**
     * Method checks if user exists
     *
     * @param email
     * @param password
     * @return object of type UserDto
     */
    @Override
    public UserDto login(String email, String password) {
        List<UserDto> users = userDao.
                getByFields(new UserBuilder(), email)
                .stream()
                .filter(user -> user.getPassword().equals(password))
                .map(new UserDtoMapper()::fromDtoToEntity)
                .collect(Collectors.toList());
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    /**
     * Method changes account password
     *
     * @param email
     * @param newPassword
     * @return boolean result of changing
     */
    @Override
    public boolean changePassword(String newPassword, String email) {
        return userDao.updateByFields(newPassword, email);
    }

    /**
     * Method saves new user in database
     *
     * @param userDto
     * @return boolean result of saving
     */
    @Override
    public boolean save(UserDto userDto) {
        if (userDao.getByFields(new UserBuilder(), userDto.getEmail()).isEmpty()) {
            User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getName(), userDto.getSurname());
            return userDao.insert(user);
        }
        return false;
    }

    /**
     * Method deletes user from database
     *
     * @param id
     * @return boolean result of deleting
     */
    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteById(id);
    }

}