package com.epam.service;

import com.epam.dto.UserDto;

public interface UserService {
    UserDto login(String email, String password);

}