package org.example.controller;

import org.example.model.TodoDBConnection;
import org.example.model.TodoModel;
import org.example.view.TodoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TodoController {
    private TodoModel todoModel;
    private TodoView todoView;
    private TodoDBConnection todoDBConnection;

    public TodoController(TodoModel todoModel, TodoView todoView) {
        this.todoModel = todoModel;
        this.todoView = todoView;

        // 뷰의 버튼에 액션 리스너 추가
        todoView.addPrevDayButtonListener(new PrevDayButtonListener());
        todoView.addNextDayButtonListener(new NextDayButtonListener());
        todoView.addAddTodoButtonListener(new AddTodoButtonListener());

        // 초기 투두 로드
        todoView.loadTodosFromDatabase();
    }

    //전날 버튼 리스너
    private class PrevDayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date previousDate = todoView.getPreviousDate(todoView.getCurrentDate());
            todoView.setCurrentDate(previousDate);
            todoView.updateDateLabel();
            todoView.loadTodosFromDatabase();
        }
    }

    //다음날 버튼 리스너
    private class NextDayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date nextDate = todoView.getNextDate(todoView.getCurrentDate());
            todoView.setCurrentDate(nextDate);
            todoView.updateDateLabel();
            todoView.loadTodosFromDatabase();
        }
    }

    //추가 버튼 리스너
    private class AddTodoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String todoText = todoView.getTodoTextFieldText();
            Date currentDate = todoView.getCurrentDate();

            // 새로운 투두를 모델에 추가
            todoModel.addTodo(todoText, currentDate);

            // 데이터베이스에서 투두를 다시 불러오고 뷰를 업데이트
            todoView.loadTodosFromDatabase();
        }
    }


}
