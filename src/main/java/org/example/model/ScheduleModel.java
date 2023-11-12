package org.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScheduleModel {

    public void addSchedule(String title, boolean isReminder, boolean isHomework) {
        String sql = "INSERT INTO schedules(title, isReminder, isHomework) VALUES(?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setBoolean(2, isReminder);
            pstmt.setBoolean(3, isHomework);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 다른 CRUD 메서드 추가
}
