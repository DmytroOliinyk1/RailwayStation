package com.epam.dto.mapper;

import com.epam.dto.HistoryDto;
import com.epam.entity.Entity;
import com.epam.entity.History;
import com.epam.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HistoryDtoMapperTest {
    @Test
    public void fromEntityToDtoTest() {
        Entity entity = new History();
        HistoryDto historyDto = new HistoryDto();
        assertEquals(new HistoryDtoMapper().fromDtoToEntity(entity), historyDto);
    }

    @Test
    public void fromEntityToDtoFailTest() {
        Entity entity = new User();
        assertThrows(ClassCastException.class, () -> new HistoryDtoMapper().fromDtoToEntity(entity));
    }
}
