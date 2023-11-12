package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DateDetailDialog extends JDialog {
    private List<JTextField> titleFields;
    private List<JCheckBox> reminderCheckBoxes;
    private List<JCheckBox> homeworkCheckBoxes;
    private JPanel schedulesPanel;
    private JButton saveButton;
    private JButton addButton;

    public DateDetailDialog(JFrame parent) {
        super(parent, "일정 상세", true);
        setSize(800, 600);
        setLayout(new BorderLayout());

        titleFields = new ArrayList<>();
        reminderCheckBoxes = new ArrayList<>();
        homeworkCheckBoxes = new ArrayList<>();

        schedulesPanel = new JPanel();
        schedulesPanel.setLayout(new BoxLayout(schedulesPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(schedulesPanel);
        add(scrollPane, BorderLayout.CENTER);

        addButton = new JButton("+");
        addButton.addActionListener(e -> addSchedulePanel());
        add(addButton, BorderLayout.NORTH);

        saveButton = new JButton("저장");
        saveButton.addActionListener(e -> saveSchedules());
        add(saveButton, BorderLayout.SOUTH);
    }

    private void addSchedulePanel() {
        JPanel schedulePanel = new JPanel();
        JTextField titleField = new JTextField(30);
        JCheckBox reminderCheckBox = new JCheckBox("리마인더");
        JCheckBox homeworkCheckBox = new JCheckBox("과제");

        titleFields.add(titleField);
        reminderCheckBoxes.add(reminderCheckBox);
        homeworkCheckBoxes.add(homeworkCheckBox);

        schedulePanel.add(titleField);
        schedulePanel.add(reminderCheckBox);
        schedulePanel.add(homeworkCheckBox);

        schedulesPanel.add(schedulePanel);
        schedulesPanel.revalidate();
        schedulesPanel.repaint();
    }

    private void saveSchedules() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/todoDB.sqlite");
            String sql = "INSERT INTO schedules (title, isReminder, isHomework) VALUES (?, ?, ?)";

            for (int i = 0; i < titleFields.size(); i++) {
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, titleFields.get(i).getText());
                    pstmt.setBoolean(2, reminderCheckBoxes.get(i).isSelected());
                    pstmt.setBoolean(3, homeworkCheckBoxes.get(i).isSelected());
                    pstmt.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(this, "일정이 저장되었습니다.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "데이터베이스 저장 중 오류가 발생했습니다.");
        }
    }

    public void setSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
}
