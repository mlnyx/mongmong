package org.example.controller;

import org.example.view.CalendarWindow;
import org.example.view.DateDetailDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarController {
    private CalendarWindow calendarView;
    private DateDetailDialog dateDetailView;

    public CalendarController(CalendarWindow calendarView) {
        this.calendarView = calendarView;
        this.dateDetailView = new DateDetailDialog(calendarView);

        this.calendarView.setMonthNavigationListener(new MonthNavigationListener());
        this.calendarView.setDateButtonListener(new DateButtonListener());
    }

    class MonthNavigationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int delta = e.getSource() == calendarView.prevButton ? -1 : 1;
            calendarView.navigateMonth(delta);
        }
    }

    class DateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dateDetailView.setVisible(true);
        }
    }
}
