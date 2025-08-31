package com.paokentin.model.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/paokentin?serverTimezone=America/Sao_Paulo";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    private static Connection conn = null;

    static Connection getCurrentConnection() throws SQLException {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}