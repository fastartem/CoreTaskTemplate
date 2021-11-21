package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/users_schema";
    private final static String USER = "root";
    private final static String PSW = "11111";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PSW);
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return connection;
    }

}
