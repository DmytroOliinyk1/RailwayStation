package com.epam.dto.mapper;

import com.epam.dto.TrainDto;
import com.epam.entity.Entity;
import com.epam.entity.History;
import com.epam.entity.Train;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainDtoMapperTest {
    @Test
    public void fromEntityToDtoTest() {
        Entity entity = new Train();
        TrainDto trainDto = new TrainDto();
        assertEquals(new TrainDtoMapper().fromDtoToEntity(entity), trainDto);
    }

    @Test
    public void fromEntityToDtoFailTest() {
        Entity entity = new History();
        assertThrows(ClassCastException.class, () -> new TrainDtoMapper().fromDtoToEntity(entity));
    }
}
