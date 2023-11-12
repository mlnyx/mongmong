package org.example.controller;

import org.example.model.ScheduleModel;
import org.example.view.DateDetailDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleController {
    private ScheduleModel model;
    private DateDetailDialog view;

    public ScheduleController(ScheduleModel model, DateDetailDialog view) {
        this.model = model;
        this.view = view;

        view.setSaveButtonListener(new SaveButtonListener());
    }

    class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 일정 저장 로직
            view.dispose();
        }
    }
}
