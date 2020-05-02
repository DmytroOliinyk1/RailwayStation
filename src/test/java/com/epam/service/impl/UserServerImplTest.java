package com.epam.service.impl;

import com.epam.dao.UserDao;
import com.epam.dto.UserDto;
import com.epam.entity.User;
import com.epam.exception.NotDeleteException;
import com.epam.exception.NotFoundException;
import com.epam.exception.NotSaveException;
import com.epam.exception.NotUpdateException;
import com.epam.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserServerImplTest {
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @BeforeEach
    public void init() {
        initMocks(this);
    }

    @Test
    public void loginTest() {

        UserDto userDto = new UserDto(
                "email", "password",
                "name", "surname"
        );

        User user = new User(
                "email", "password",
                "name", "surname"
        );
        List<User> users = Arrays.asList(user);
        when(userDao.getByFields(any(), anyString())).thenReturn(users);
        assertEquals(userService.login("email", "password"), userDto);
    }

    @Test
    public void loginFailTest() {
        when(userDao.getByFields(any(), anyString())).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> userService.login("email", "password"));
    }

    @Test
    public void changePasswordTest() {
        when(userDao.updateByFields(anyString(), anyString())).thenReturn(true);
        assertTrue(userService.changePassword( "email", "newPassword"));
    }

    @Test
    public void changePasswordFailTest() {
        when(userDao.updateByFields(anyString(), anyString())).thenThrow(NotUpdateException.class);
        assertThrows(NotUpdateException.class, () ->
                userService.changePassword( "email", "newPassword"));
    }

    @Test
    public void saveTest() {

        UserDto userDto = new UserDto(
                "email", "password",
                "name", "surname"
        );

        when(userDao.getByFields(any(), anyString())).thenReturn(new ArrayList<>());
        when(userDao.insert(any())).thenReturn(true);
        assertTrue(userService.save(userDto));
    }

    @Test
    public void saveFailTest() {

        UserDto userDto = new UserDto(
                "email", "password",
                "name", "surname"
        );

        when(userDao.getByFields(any(), anyString())).thenReturn(new ArrayList<>());
        when(userDao.insert(any())).thenThrow(NotSaveException.class);
        assertThrows(NotSaveException.class, () -> userService.save(userDto));
    }

    @Test
    public void deleteUserTest() {
        Long id = Long.valueOf(1);

        when(userDao.deleteById(anyLong())).thenReturn(true);
        assertTrue(userService.deleteUser(id));
    }

    @Test
    public void deleteUserFailTest() {
        Long id = Long.valueOf(1);

        when(userDao.deleteById(anyLong())).thenThrow(NotDeleteException.class);
        assertThrows(NotDeleteException.class, () -> userService.deleteUser(id));
    }
}
