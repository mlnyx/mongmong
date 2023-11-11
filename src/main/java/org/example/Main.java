package org.example;

import org.example.view.Guide;
import org.example.view.StartPage;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StartPage(); // 시작 페이지 인스턴스를 생성합니다.
        });
    }

    public static void openGuide() {
        SwingUtilities.invokeLater(() -> {
            new Guide(); // 가이드 페이지 인스턴스를 생성합니다.
        });
    }
}
