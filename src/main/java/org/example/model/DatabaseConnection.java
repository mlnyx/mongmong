package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:path_to_your_database.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            // SQLite 데이터베이스 연결
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS schedules (\n"
                + " id integer PRIMARY KEY,\n"
                + " title text NOT NULL,\n"
                + " isReminder boolean,\n"
                + " isHomework boolean\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // 테이블 생성
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
