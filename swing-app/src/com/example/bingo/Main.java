package com.example.bingo;

public class Main {
    private BingoModel bingoModel;
    private BingoView bingoView;
    private BingoPresenter bingoPresenter;

    public static void main(String[] args) {
        Main main = new Main();
        main.initialize();
    }

    public void initialize() {
        bingoModel = new BingoModel();
        bingoView = new BingoView();
        bingoPresenter = new BingoPresenter(bingoModel, bingoView);
        bingoView.setVisible(true);
        bingoPresenter.startGame(); // ゲーム開始時にこのメソッドを呼び出す
    }
}
