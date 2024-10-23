package com.example.bingo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import com.example.bingo.history.BingoHistoryView;
import com.example.bingo.numberdisplay.NumberDisplayView;
import com.example.bingo.ui.AppButton;

public class BingoView extends JFrame {
    private final BingoHistoryView bingoHistoryView;
    private final NumberDisplayView numberDisplayView;
    private final AppButton drawButton;
    private final AppButton resetButton;

    public BingoHistoryView getBingoHistoryView() {
        return bingoHistoryView;
    }

    public NumberDisplayView getNumberDisplayView() {
        return numberDisplayView;
    }

    public BingoView() {
        setTitle("Bingo Game");
        setPreferredSize(new Dimension(900, 700));
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 240, 245)); // ラベンダーブラッシュ

        // 上半分のパネルを作成
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.setBorder(new EmptyBorder(10, 10, 5, 10));

        // NumberDisplayViewを作成し、左側に配置
        numberDisplayView = new NumberDisplayView();
        topPanel.add(numberDisplayView, BorderLayout.CENTER);

        // ボタンパネルを作成し、右側に配置
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.setOpaque(false);
        drawButton = new AppButton("NEXT");
        resetButton = new AppButton("RESET");
        buttonPanel.add(drawButton);
        buttonPanel.add(resetButton);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        // 下半分のパネル（履歴ビュー）を作成
        bingoHistoryView = new BingoHistoryView();
        bingoHistoryView.setBorder(new EmptyBorder(5, 10, 10, 10));

        // JSplitPaneを使用して上下に分割
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bingoHistoryView);
        splitPane.setResizeWeight(0.5);
        splitPane.setOpaque(false);
        splitPane.setBorder(null);
        add(splitPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setResizable(true);
    }

    public void setDrawButtonListener(Runnable listener) {
        drawButton.addActionListener(e -> listener.run());
    }

    public void setResetButtonListener(Runnable listener) {
        resetButton.addActionListener(e -> listener.run());
    }

    public void setDrawButtonEnabled(boolean enabled) {
        drawButton.setEnabled(enabled);
    }

    public void resetView() {
        bingoHistoryView.reset();
        drawButton.setEnabled(true);
    }
}
