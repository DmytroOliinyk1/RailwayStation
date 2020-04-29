package com.epam.service;

import com.epam.dao.builder.UserBuilder;
import com.epam.dto.UserDto;
import com.epam.entity.User;

public interface UserService {
    UserDto login(String email, String password);


    public boolean save(UserDto userDto);
}