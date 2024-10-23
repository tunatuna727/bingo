package com.example.bingo.numberdisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NumberDisplayView extends JPanel {
  private final JLabel numberLabel;

  public NumberDisplayView() {
    setLayout(new BorderLayout());
    setBackground(new Color(255, 228, 225)); // ミスティローズ

    numberLabel = new JLabel("", SwingConstants.CENTER);
    numberLabel.setFont(new Font("Arial", Font.BOLD, 180));
    numberLabel.setForeground(new Color(255, 105, 180)); // ホットピンク
    add(numberLabel, BorderLayout.CENTER);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setColor(Color.WHITE);
    g2d.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 30, 30);

    g2d.dispose();
  }

  public void updateNumber(int number) {
    numberLabel.setText(String.valueOf(number));
  }

  public void showGameEnded() {
    numberLabel.setText("終了");
  }

  public void reset() {
    numberLabel.setText("");
  }
}
