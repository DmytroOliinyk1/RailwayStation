package com.epam.dto.mapper;

import com.epam.controller.user.LoginServlet;
import com.epam.dto.UserDto;
import com.epam.entity.Entity;
import com.epam.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDtoMapper implements DtoMapper<UserDto> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserDtoMapper.class);

    /**
     * Method converts Entity to UserDto.
     *
     * @param entity
     * @return object type of UserDto
     */
    @Override
    public UserDto fromDtoToEntity(Entity entity) {
        User user = (User) entity;
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        LOGGER.info("Created UserDto from User");
        return userDto;
    }
}