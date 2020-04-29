package com.epam.dto.mapper;

import com.epam.dto.UserDto;
import com.epam.entity.Entity;
import com.epam.entity.User;

public class UserDtoMapper implements DtoMapper<UserDto> {
    @Override
    public UserDto fromDtoToEntity(Entity entity) {
        User user = (User)entity;
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }
}