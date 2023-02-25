package com.jsp.database;

import org.h2.Driver;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new Driver());

            String jdbcURL = "jdbc:h2:tcp://localhost/~/Desktop/Board/board";
            conn = DriverManager.getConnection(jdbcURL, "dbconnect", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(PreparedStatement stmt, Connection comm) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            comm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection comm) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            comm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}