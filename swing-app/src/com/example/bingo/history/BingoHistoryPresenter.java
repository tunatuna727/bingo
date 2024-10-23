package com.example.bingo.history;

public class BingoHistoryPresenter {
    private final BingoHistoryModel bingoHistoryModel;
    private final BingoHistoryView bingoHistoryView;

    public BingoHistoryPresenter(BingoHistoryModel bingoHistoryModel, BingoHistoryView bingoHistoryView) {
        this.bingoHistoryModel = bingoHistoryModel;
        this.bingoHistoryView = bingoHistoryView;
    }

    public void reset() {
        bingoHistoryModel.reset();
        bingoHistoryView.reset();
    }

    public void addDrawnNumber(int number) {
        bingoHistoryModel.addDrawnNumber(number);
        bingoHistoryView.addDrawnNumber(number);
    }
}
