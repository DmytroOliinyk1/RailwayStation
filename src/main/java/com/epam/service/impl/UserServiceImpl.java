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

    @Override
    public boolean save(UserDto userDto) {
        if (userDao.getByFields(new UserBuilder(), userDto.getEmail()).isEmpty()) {
            User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getName(), userDto.getSurname());
            return userDao.insert(user);
        }
        return false;
    }

}