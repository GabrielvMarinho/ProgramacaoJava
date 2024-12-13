package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final String URL = "jdbc:mysql://localhost:3306/db_gabriel";
    private final String USER = "root";
    private final String KEY = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, KEY);
    }
}
