package com.epam.service;

import com.epam.dto.UserDto;

public interface UserService {
    UserDto login(String email, String password);

    boolean save(UserDto userDto);

    boolean changePassword(String email, String newPassword);

    boolean deleteUser(Long id);
}