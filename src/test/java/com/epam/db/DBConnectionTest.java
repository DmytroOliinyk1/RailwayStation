package com.epam.db;

import com.epam.entity.SqlQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;

public class DBConnectionTest {

    @Test
    public void getConnectionTest(){
        Connection connection = DBConnection.getConnection();
        assertNotNull(connection);
    }
}
