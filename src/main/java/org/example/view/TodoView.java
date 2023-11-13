package org.example.view;

import org.example.controller.TodoController;
import org.example.model.TodoDBConnection;
import org.example.model.TodoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TodoView extends JPanel {

    private JLabel dateLabel;
    private JButton prevDayButton;
    private JButton nextDayButton;
    private JTextField todoTextField;
    private JButton addTodoButton;
    private JPanel todoListPanel;
    private Date currentDate;
    private TodoDBConnection todoDBConnection;
    private TodoModel todoModel;

    public TodoView(TodoModel todoModel) {
        todoDBConnection = new TodoDBConnection();


        setLayout(new BorderLayout());
        currentDate = new Date();

        dateLabel = new JLabel();
        updateDateLabel();
        add(dateLabel, BorderLayout.NORTH);

        JPanel dateControlPanel = new JPanel();
        prevDayButton = new JButton("←");
        nextDayButton = new JButton("→");

        dateControlPanel.add(prevDayButton);
        dateControlPanel.add(dateLabel);
        dateControlPanel.add(nextDayButton);

        add(dateControlPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(100, 50));
        todoTextField = new JTextField(20);
        addTodoButton = new JButton("추가");

        inputPanel.add(todoTextField);
        inputPanel.add(addTodoButton);
        add(inputPanel, BorderLayout.SOUTH);

        todoListPanel = new JPanel();
        todoListPanel.setLayout(new BoxLayout(todoListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(todoListPanel);
        add(scrollPane, BorderLayout.CENTER);


    }

    public void addPrevDayButtonListener(ActionListener listener) {
        prevDayButton.addActionListener(listener);
    }

    public void addNextDayButtonListener(ActionListener listener) {
        nextDayButton.addActionListener(listener);
    }

    public void addAddTodoButtonListener(ActionListener listener) {
        addTodoButton.addActionListener(listener);
    }

    public void updateDateLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateLabel.setText(dateFormat.format(currentDate));
    }

    public void setCurrentDate(Date date) {
        this.currentDate = date;
        loadTodosFromDatabase();
        updateDateLabel();
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    //전날 날짜 가져오기
    public Date getPreviousDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    public Date getNextDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    public String getTodoTextFieldText() {
        return todoTextField.getText();
    }

    public void loadTodosFromDatabase() {
        try {
            List<String> todos = todoDBConnection.getTodosForDate(currentDate);

            //디버깅 출력문
            System.out.println("Todos from database: " + todos);

            todoListPanel.removeAll();

            for (String todo : todos) {
                int isCompleted = todoDBConnection.getTodoCompletedStatus(todo);
                addTodoItem(todo, isCompleted);
            }


            todoListPanel.revalidate();
            todoListPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            todoDBConnection.closeConnection();
        }
    }

    //아이템 추가하기
    //체크박스 확인하기까지
    private void addTodoItem(String todoText, int isCompleted) {
        JPanel todoItemPanel = new JPanel();
        JCheckBox checkBox = new JCheckBox();
        JLabel todoTextLabel = new JLabel(todoText);

        checkBox.setSelected(isCompleted == 1);





        todoItemPanel.add(checkBox);
        todoItemPanel.add(todoTextLabel);

        todoListPanel.add(todoItemPanel);
        todoListPanel.revalidate();
    }


}