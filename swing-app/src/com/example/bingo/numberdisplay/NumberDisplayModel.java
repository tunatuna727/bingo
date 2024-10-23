package com.example.bingo.numberdisplay;

public class NumberDisplayModel {
    private int currentNumber;

    public void setCurrentNumber(int number) {
        this.currentNumber = number;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void reset() {
        currentNumber = 0;
    }
}
