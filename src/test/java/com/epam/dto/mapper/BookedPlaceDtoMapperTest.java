package com.epam.dto.mapper;

import com.epam.dto.BookedPlaceDto;
import com.epam.entity.Entity;
import com.epam.entity.History;
import com.epam.entity.BookedPlace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookedPlaceDtoMapperTest {
    @Test
    public void fromEntityToDtoTest() {
        Entity entity = new BookedPlace();
        BookedPlaceDto bookedPlaceDto = new BookedPlaceDto();
        assertEquals(new BookedPlaceDtoMapper().fromDtoToEntity(entity), bookedPlaceDto);
    }

    @Test
    public void fromEntityToDtoFailTest() {
        Entity entity = new History();
        assertThrows(ClassCastException.class, () -> new BookedPlaceDtoMapper().fromDtoToEntity(entity));
    }
}
