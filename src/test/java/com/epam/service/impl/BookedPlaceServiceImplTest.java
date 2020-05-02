package com.epam.service.impl;

import com.epam.dao.BookedPlaceDao;
import com.epam.dto.BookedPlaceDto;
import com.epam.dto.mapper.BookedPlaceDtoMapper;
import com.epam.entity.BookedPlace;
import com.epam.exception.NotDeleteException;
import com.epam.exception.NotFoundException;
import com.epam.exception.NotSaveException;
import com.epam.service.BookedPlaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookedPlaceServiceImplTest {
    @Mock
    BookedPlaceDao bookedPlaceDao;

    @InjectMocks
    BookedPlaceService bookedPlaceService = new BookedPlaceServiceImpl();

    @BeforeEach
    public void init() {
        initMocks(this);
    }

    @Test
    public void getDisabledPlacesTest() {
        BookedPlace bookedPlace = new BookedPlace();
        BookedPlaceDto bookedPlaceDto = new BookedPlaceDtoMapper().fromDtoToEntity(bookedPlace);

        List<BookedPlace> bookedPlaces = Arrays.asList(bookedPlace);
        List<BookedPlaceDto> bookedPlaceDtos = Arrays.asList(bookedPlaceDto);

        when(bookedPlaceDao.getByFields(any(), any(), any(), any(), any())).thenReturn(bookedPlaces);
        assertEquals(bookedPlaceService.getDisabledPlaces(bookedPlaceDto), bookedPlaceDtos);
    }

    @Test
    public void getDisabledPlacesFailTest() {
        when(bookedPlaceDao.getByFields(any(), any(), any(), any(), any())).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> bookedPlaceService.getDisabledPlaces(new BookedPlaceDto()));
    }

    @Test
    public void saveBookedPlaceTest() {
        when(bookedPlaceDao.insert(any())).thenReturn(true);
        assertTrue(bookedPlaceService.saveBookedPlace(new BookedPlaceDto()));
    }

    @Test
    public void saveBookedPlaceFailTest() {
        when(bookedPlaceDao.insert(any())).thenThrow(NotSaveException.class);
        assertThrows(NotSaveException.class, () -> bookedPlaceService.saveBookedPlace(new BookedPlaceDto()));
    }

    @Test
    public void cancelBookTest() {
        when(bookedPlaceDao.deleteByFields(any(), any(), any(), any())).thenReturn(true);
        assertTrue(bookedPlaceService.cancelBook(new BookedPlaceDto()));
    }

    @Test
    public void cancelBookFailTest() {
        when(bookedPlaceDao.deleteByFields(any(), any(), any(), any())).thenThrow(NotDeleteException.class);
        assertThrows(NotDeleteException.class, () -> bookedPlaceService.cancelBook(new BookedPlaceDto()));
    }
}
