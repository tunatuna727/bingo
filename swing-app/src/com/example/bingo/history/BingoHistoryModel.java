package com.example.bingo.history; //パッケージ宣言

import java.util.ArrayList;
import java.util.List;

public class BingoHistoryModel {
  private final List<Integer> drawnNumbers;

  public BingoHistoryModel() {
    drawnNumbers = new ArrayList<>();
  }

  public void addDrawnNumber(int number) { //引かれたビンゴの数字をリストに追加
    drawnNumbers.add(number);
  }

  public void reset() {//ビンゴの履歴をリセット
    drawnNumbers.clear();
  }
}
