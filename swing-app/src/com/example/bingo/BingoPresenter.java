package com.example.bingo;

import com.example.bingo.history.BingoHistoryPresenter;
import com.example.bingo.numberdisplay.NumberDisplayPresenter;

public class BingoPresenter {
    private final BingoModel bingoModel;
    private final BingoView bingoView;

    private final BingoHistoryPresenter bingoHistoryPresenter;
    private final NumberDisplayPresenter numberDisplayPresenter;

    public BingoPresenter(BingoModel bingoModel, BingoView bingoView) {
        this.bingoModel = bingoModel;
        this.bingoView = bingoView;

        numberDisplayPresenter = new NumberDisplayPresenter(bingoModel.getNumberDisplayModel(), bingoView.getNumberDisplayView());
        bingoHistoryPresenter = new BingoHistoryPresenter(bingoModel.getBingoHistoryModel(), bingoView.getBingoHistoryView());

        setupViewListeners();
    }

    private void setupViewListeners() {
        bingoView.setDrawButtonListener(this::drawNumber);
        bingoView.setResetButtonListener(this::resetGame);
    }

    private void drawNumber() {
        int drawnNumber = bingoModel.drawNumber();
        if (drawnNumber != -1) {
            updatePresenters(drawnNumber);
        }
        checkGameEnd();
    }

    private void updatePresenters(int drawnNumber) {
        numberDisplayPresenter.updateNumber(drawnNumber);
        bingoHistoryPresenter.addDrawnNumber(drawnNumber);
    }

    private void checkGameEnd() {
        if (bingoModel.isGameEnded()) {
            endGame();
        }
    }

    private void endGame() {
        numberDisplayPresenter.showGameEnded();
        bingoView.setDrawButtonEnabled(false);
    }

    private void resetGame() {
        bingoModel.resetNumbers();
        bingoView.resetView();
        numberDisplayPresenter.reset();
        bingoHistoryPresenter.reset();
    }

    // 新しいメソッド：ゲーム開始時に呼び出す
    public void startGame() {
        if (bingoModel.isGameEnded()) {
            endGame();
        }
    }
}
