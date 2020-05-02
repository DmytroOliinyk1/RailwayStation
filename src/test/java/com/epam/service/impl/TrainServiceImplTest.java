package com.epam.service.impl;

import com.epam.dao.TrainDao;
import com.epam.dto.TrainDto;
import com.epam.dto.mapper.TrainDtoMapper;
import com.epam.entity.Train;
import com.epam.exception.NotFoundException;
import com.epam.service.TrainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TrainServiceImplTest {
    @Mock
    private TrainDao trainDao;

    @InjectMocks
    private TrainService trainService = new TrainServiceImpl();

    @BeforeEach
    public void init() {
        initMocks(this);
    }

    @Test
    public void getAvailableTrainTest() {

        Train train = new Train();
        TrainDto trainDto = new TrainDtoMapper().fromDtoToEntity(train);

        List<Train> trains = Arrays.asList(train);
        List<TrainDto> trainDtos = Arrays.asList(trainDto);

        when(trainDao.getByFields(any(), anyString(), anyString())).thenReturn(trains);
        assertEquals(trainService.getAvailableTrain("F", "T"), trainDtos);
    }

    @Test
    public void getAvailableTrainFailTest() {
        when(trainDao.getByFields(any(), anyString(), anyString())).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> trainService.getAvailableTrain("F", "T"));
    }

    @Test
    public void getTrainTest() {
        Train train = new Train(
                Long.valueOf(1), "000", "F", "T",
                new Time(new Date().getTime()), new Time(new Date().getTime()), Long.valueOf(1), Long.valueOf(1),
                new BigDecimal("000.00")
        );

        TrainDto trainDto = new TrainDtoMapper().fromDtoToEntity(train);

        when(trainDao.getById(any(), anyLong())).thenReturn(train);
        assertEquals(trainService.getTrain(Long.valueOf(1)), trainDto);
    }

    @Test
    public void getTrainFailTest() {
        when(trainDao.getById(any(), anyLong())).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> trainService.getTrain(Long.valueOf(1)));
    }
}
