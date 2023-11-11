package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Guide extends JFrame {
    private JLabel imageLabel;
    private JLabel pageNumberLabel;
    private JButton nextButton;
    private JButton prevButton;
    private int currentImageIndex = 0;
    private String[] imagePaths = new String[]{
            "guide_img1.png",
            "guide_img1.png"
    };

    public Guide() {
        setTitle("사용법");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        pageNumberLabel = new JLabel("페이지: 1");
        pageNumberLabel.setHorizontalAlignment(JLabel.CENTER);

        prevButton = new JButton("이전");
        nextButton = new JButton("다음");

        prevButton.addActionListener(e -> showPreviousImage());
        nextButton.addActionListener(e -> showNextImage());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(prevButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(nextButton);

        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
        add(pageNumberLabel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.PAGE_START);

        showImage(currentImageIndex);
        setVisible(true);
    }

    private void showImage(int index) {
        String imagePath = imagePaths[index];
        URL imageUrl = getClass().getClassLoader().getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            imageLabel.setIcon(imageIcon);
            pageNumberLabel.setText("페이지: " + (index + 1));
        } else {
            System.err.println("Image not found: " + imagePath);
        }
    }

    private void showNextImage() {
        if (currentImageIndex < imagePaths.length - 1) {
            currentImageIndex++;
            showImage(currentImageIndex);
        }
    }

    private void showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--;
            showImage(currentImageIndex);
        }
    }
}
