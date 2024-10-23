package com.example.bingo.history;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BingoHistoryCell extends JLabel {
    private static final int CELL_SIZE = 30;
    private static final Color ACTIVE_BACKGROUND = new Color(255, 182, 193); 
    private static final Color ACTIVE_FOREGROUND = Color.WHITE;
    private static final Color INACTIVE_BORDER = new Color(255, 228, 225); 

    private boolean isActive = false;

    public BingoHistoryCell() { //セルの初期設定
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
        setOpaque(false);
    }

    public void setActive(int number) {
        setText(String.valueOf(number));
        isActive = true;
        setForeground(ACTIVE_FOREGROUND);
        setFont(new Font("Arial", Font.BOLD, 12));
        repaint();
    }

    public void setInactive() {
        setText("");
        isActive = false;
        repaint(); //セルの描画を更新
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isActive) {
            g2d.setColor(ACTIVE_BACKGROUND);
            g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        } else {
            g2d.setColor(INACTIVE_BORDER);
            g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        }

        g2d.dispose();
        super.paintComponent(g);
    }
}
