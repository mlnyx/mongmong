package org.example;

import org.example.model.DatabaseConnection;
import org.example.view.DogPage;
import org.example.view.Guide;
import org.example.view.StartPage;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StartPage(); // 시작 페이지 인스턴스를 생성합니다.

            DatabaseConnection.createNewTable();
        });
    }

}
