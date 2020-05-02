package com.epam.dto.mapper;

import com.epam.dto.UserDto;
import com.epam.entity.Entity;
import com.epam.entity.History;
import com.epam.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDtoMapperTest {
    @Test
    public void fromEntityToDtoTest() {
        Entity entity = new User();
        UserDto userDto = new UserDto();
        assertEquals(new UserDtoMapper().fromDtoToEntity(entity), userDto);
    }

    @Test
    public void fromEntityToDtoFailTest() {
        Entity entity = new History();
        assertThrows(ClassCastException.class, () -> new UserDtoMapper().fromDtoToEntity(entity));
    }
}
