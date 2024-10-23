package com.example.bingo;

import java.util.ArrayList;
import java.util.List;

import com.example.bingo.history.BingoHistoryModel;
import com.example.bingo.numberdisplay.NumberDisplayModel;

public class BingoModel {
    private final BingoHistoryModel bingoHistoryModel;
    private final NumberDisplayModel numberDisplayModel;

    public BingoHistoryModel getBingoHistoryModel() {
        return bingoHistoryModel;
    }

    public NumberDisplayModel getNumberDisplayModel() {
        return numberDisplayModel;
    }

    private final List<Integer> numbers;
    private boolean gameEnded;

    public BingoModel() {
        numbers = new ArrayList<>();
        resetNumbers();
        bingoHistoryModel = new BingoHistoryModel();
        numberDisplayModel = new NumberDisplayModel();
    }

    public void resetNumbers() {
        numbers.clear();
        for (int i = 1; i <= 75; i++) {
            numbers.add(i);
        }
        gameEnded = false;
    }

    public int drawNumber() {
        if (numbers.isEmpty()) {
            gameEnded = true;
            return -1;
        }

        int index = (int) (Math.random() * numbers.size());
        return numbers.remove(index);
    }

    public boolean isGameEnded() {
        return numbers.isEmpty();
    }
}
