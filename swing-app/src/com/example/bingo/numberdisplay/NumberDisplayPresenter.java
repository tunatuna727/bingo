package com.example.bingo.numberdisplay;

public class NumberDisplayPresenter {
    private final NumberDisplayModel numberDisplayModel;
    private final NumberDisplayView numberDisplayView;

    public NumberDisplayPresenter(NumberDisplayModel numberDisplayModel, NumberDisplayView numberDisplayView) {
        this.numberDisplayModel = numberDisplayModel;
        this.numberDisplayView = numberDisplayView;
    }

    public void updateNumber(int number) {
        numberDisplayModel.setCurrentNumber(number);
        numberDisplayView.updateNumber(number);
    }

    public void showGameEnded() {
        numberDisplayView.showGameEnded();
    }

    public void reset() {
        numberDisplayModel.reset();
        numberDisplayView.reset();
    }
}
