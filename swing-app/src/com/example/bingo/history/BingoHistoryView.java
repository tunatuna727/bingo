package com.example.bingo.history;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BingoHistoryView extends JPanel {
    private static final int GRID_ROWS = 5;
    private static final int GRID_COLS = 15;
    private static final int TOTAL_CELLS = GRID_ROWS * GRID_COLS;

    private final List<Integer> historyNumbers;
    private final JPanel historyPanel;
    private final BingoHistoryCell[] cells;

    public BingoHistoryView() {
        setLayout(new BorderLayout());
        historyNumbers = new ArrayList<>();
        historyPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS, 2, 2));
        historyPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cells = new BingoHistoryCell[TOTAL_CELLS];
        initializeHistoryPanel();

        JPanel historyContainer = new JPanel(new BorderLayout());
        historyContainer.add(historyPanel, BorderLayout.CENTER);
        historyContainer.setBorder(BorderFactory.createTitledBorder("Number History"));
        add(historyContainer, BorderLayout.CENTER);
    }

    private void initializeHistoryPanel() {
        for (int i = 0; i < TOTAL_CELLS; i++) {
            cells[i] = new BingoHistoryCell();
            historyPanel.add(cells[i]);
        }
    }

    public void addNumber(int number) {
        historyNumbers.add(number);
        updateHistory();
    }

    public void reset() {
        historyNumbers.clear();
        updateHistory();
    }

    private void updateHistory() { //75個のセルの状態を更新
        for (int i = 0; i < TOTAL_CELLS; i++) {
            if (i < historyNumbers.size()) {
                cells[i].setActive(historyNumbers.get(i));
            } else {
                cells[i].setInactive();
            }
        }
        historyPanel.revalidate();
        historyPanel.repaint();
    }

    public void addDrawnNumber(int number) {
        if (!historyNumbers.contains(number)) {
            historyNumbers.add(number);
            updateHistory();
        }
    }
}
