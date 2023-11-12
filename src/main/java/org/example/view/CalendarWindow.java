package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CalendarWindow extends JFrame {
    private Calendar calendar;
    private JLabel monthLabel;
    private JPanel daysPanel;
    public JButton prevButton;
    private JButton nextButton;

    public CalendarWindow() {
        calendar = Calendar.getInstance();
        setTitle("캘린더");
        setSize(800, 1000);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        monthLabel = new JLabel("", JLabel.CENTER);
        monthLabel.setFont(new Font("Arial", Font.BOLD, 24));
        updateMonthLabel();

        prevButton = new JButton("<");
        nextButton = new JButton(">");

        JPanel monthPanel = new JPanel();
        monthPanel.add(prevButton);
        monthPanel.add(monthLabel);
        monthPanel.add(nextButton);

        add(monthPanel, BorderLayout.NORTH);

        daysPanel = new JPanel(new GridLayout(0, 7, 5, 5));
        add(daysPanel, BorderLayout.CENTER);

        updateCalendar();
    }

    public void updateCalendar() {
        daysPanel.removeAll();
        Calendar tempCalendar = (Calendar) calendar.clone();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 1);

        int startDayOfWeek = tempCalendar.get(Calendar.DAY_OF_WEEK);
        int maxDay = tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < startDayOfWeek; i++) {
            daysPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= maxDay; day++) {
            JButton dayButton = new JButton(String.valueOf(day));
            dayButton.setHorizontalAlignment(SwingConstants.LEFT);
            dayButton.setVerticalAlignment(SwingConstants.TOP);
            if ((day + startDayOfWeek - 1) % 7 == 1) {
                dayButton.setForeground(Color.RED);
            } else if ((day + startDayOfWeek - 1) % 7 == 0) {
                dayButton.setForeground(Color.BLUE);
            }
            daysPanel.add(dayButton);
        }

        daysPanel.revalidate();
        daysPanel.repaint();
    }

    public void setMonthNavigationListener(ActionListener listener) {
        prevButton.addActionListener(listener);
        nextButton.addActionListener(listener);
    }

    public void setDateButtonListener(ActionListener listener) {
        Component[] components = daysPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(listener);
            }
        }
    }

    private void updateMonthLabel() {
        monthLabel.setText(calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH) + 1) + "월");
    }

    public void navigateMonth(int delta) {
        calendar.add(Calendar.MONTH, delta);
        updateMonthLabel();
        updateCalendar();
    }
}
