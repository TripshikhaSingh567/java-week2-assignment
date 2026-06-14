package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles database connectivity.
 */
public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_db";

    private static final String USERNAME =
            "root";

    private static final String PASSWORD =
            "Tripshikha#1234";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USERNAME,
                PASSWORD
        );
    }
}