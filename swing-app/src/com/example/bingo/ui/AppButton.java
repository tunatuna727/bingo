package com.example.bingo.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class AppButton extends JButton {
    public AppButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setBackground(new Color(255, 105, 180)); // ホットピンク
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(255, 20, 147)); // ディープピンク（押下時）
        } else {
            g.setColor(getBackground());
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }
}
