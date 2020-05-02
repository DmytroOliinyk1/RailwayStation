package com.epam.service.impl;

import com.epam.dao.HistoryDao;

import com.epam.dto.BookedPlaceDto;
import com.epam.dto.HistoryDto;
import com.epam.dto.TrainDto;

import com.epam.dto.mapper.HistoryDtoMapper;
import com.epam.entity.History;
import com.epam.exception.NotDeleteException;
import com.epam.exception.NotFoundException;
import com.epam.exception.NotSaveException;
import com.epam.service.HistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

public class HistoryServiceImplTest {
    @Mock
    private HistoryDao historyDao;

    @InjectMocks
    private HistoryService historyService = new HistoryServiceImpl();

    @BeforeEach
    public void init() {
        initMocks(this);
    }

    @Test
    public void saveTicketTest() {
        when(historyDao.insert(any())).thenReturn(true);
        assertTrue(historyService.saveTicket(new BookedPlaceDto(), new TrainDto(), new Long(1)));
    }

    @Test
    public void saveTicketFailTest() {
        when(historyDao.insert(any())).thenThrow(NotSaveException.class);
        assertThrows(NotSaveException.class, () ->
                historyService.saveTicket(new BookedPlaceDto(), new TrainDto(), new Long(1)));
    }

    @Test
    public void getHistoryTest() {
        History history = new History();
        HistoryDto historyDto = new HistoryDtoMapper().fromDtoToEntity(history);

        List<History> histories = Arrays.asList(history);
        List<HistoryDto> historyDtos = Arrays.asList(historyDto);

        when(historyDao.getByFields(any(), anyLong())).thenReturn(histories);
        assertEquals(historyService.getHistory(new Long(1)), historyDtos);
    }

    @Test
    public void getHistoryFailTest() {
        when(historyDao.getByFields(any(), anyLong())).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> historyService.getHistory(new Long(1)));
    }

    @Test
    public void deleteTest() {
        when(historyDao.deleteByFields(anyLong())).thenReturn(true);
        assertTrue(historyService.delete(new Long(1)));
    }

    @Test
    public void deleteFailTest() {
        when(historyDao.deleteByFields(anyLong())).thenThrow(NotDeleteException.class);
        assertThrows(NotDeleteException.class, () -> historyService.delete(new Long(1)));
    }
}
