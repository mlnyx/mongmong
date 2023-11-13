package org.example.model;

import java.util.Date;
import java.util.List;

public class TodoModel {
    private TodoDBConnection todoDBConnection;

    public TodoModel() {
        todoDBConnection = new TodoDBConnection();
    }

    public void addTodo(String todoText, Date todoDate) {
        todoDBConnection.addTodoDB(todoText, todoDate);
    }

    public void updateTodoChecked(String todoText, int isCompleted) {
        todoDBConnection.updateTodoChecked(todoText, isCompleted);
    }

    public List<String> getTodosForDate(Date date) {
        return todoDBConnection.getTodosForDate(date);
    }

    public int getTodoCompletedStatus(String todo) {
        return todoDBConnection.getTodoCompletedStatus(todo);
    }
}