package com.epam.db;

import com.epam.controller.user.LoginServlet;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBConnection.class);

    private final static String DB_DRIVER = "driver.class.name";
    private final static String DB_URL = "db.url";
    private final static String DB_USERNAME = "db.username";
    private final static String DB_PASSWORD = "db.password";

    private static Properties properties;
    private static BasicDataSource dataSource;

    static {
        try {
            String rootPath = Thread.currentThread()
                    .getContextClassLoader()
                    .getResource("")
                    .getPath();

            String dbProperties = rootPath + "db.properties";
            properties = new Properties();
            properties.load(new FileInputStream(dbProperties));

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty(DB_DRIVER));
            dataSource.setUrl(properties.getProperty(DB_URL));
            dataSource.setUsername(properties.getProperty(DB_USERNAME));
            dataSource.setPassword(properties.getProperty(DB_PASSWORD));

            dataSource.setMinIdle(100);
            dataSource.setMaxIdle(1000);

            LOGGER.info("Initialized datasource");

        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException: "+e.getMessage());
            throw new RuntimeException("'db.properties' not found");
        } catch (IOException e) {
            LOGGER.error("IOException: "+e.getMessage());
            throw new RuntimeException("'db.properties' not load in Properties");
        }
    }

    /**
     * Method gets connection to database
     *
     * @return object type of Connection
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("SQLException: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
