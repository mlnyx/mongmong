package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartPage extends JFrame {

    public StartPage() {
        // 윈도우 기본 설정
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("시작 페이지");
        getContentPane().setBackground(Color.WHITE);
        setLayout(new FlowLayout());

        // 이미지 레이블 설정
        URL imageUrl = getClass().getClassLoader().getResource("maindog.jpg");
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            JLabel imageLabel = new JLabel(imageIcon) {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());
                }
            };
            imageLabel.setLayout(null);
            add(imageLabel, BorderLayout.WEST);
        }

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton startButton = createButton("시작", this::goToMainPage);
        JButton guideButton = createButton("사용자 가이드", this::goToGuidePage);
        buttonPanel.add(startButton);
        buttonPanel.add(guideButton);

        // 하단 패널에 버튼 패널 추가
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.EAST);

        // 윈도우 종료 설정 및 표시
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.addActionListener(e -> action.run());
        configureButton(button);
        return button;
    }

    private void configureButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 50));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
    }

    private void goToMainPage() {
        System.out.println("메인 페이지로 이동합니다.");
        dispose();
        MainPage.main();
    }

    private void goToGuidePage() {
        System.out.println("사용자 가이드 페이지로 이동합니다.");
        new Guide(); // Guide 클래스 인스턴스 생성 및 표시
    }
}
