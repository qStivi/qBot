package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private final static Logger LOGGER = LoggerFactory.getLogger(DB.class);
    private final static String DATABASE_NAME = "qBot";
    private final static String DATABASE_DRIVER = "jdbc";
    private final static String DATABASE_TYPE = "sqlite";
    private static final Connection connection;

    public static String YEE;

    static {
        try {
            var url = DATABASE_DRIVER + ":" + DATABASE_TYPE + ":" + DATABASE_NAME + ".db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            LOGGER.error("Error while connecting to database!");
            throw new RuntimeException(e);
        }

        try {
            var stmt = connection.createStatement();
            stmt.executeQuery("""
                        CREATE TABLE IF NOT EXISTS 'users'(
                            'user_id' INTEGER PRIMARY KEY NOT NULL,
                            ''
                    )""");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
