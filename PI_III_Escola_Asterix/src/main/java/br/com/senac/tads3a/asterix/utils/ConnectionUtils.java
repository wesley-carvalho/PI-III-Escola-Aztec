package br.com.senac.tads3a.asterix.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDataSource");

        Connection connection;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/AsterixDB",
                    "root",
                    "root");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
