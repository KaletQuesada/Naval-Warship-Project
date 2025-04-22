package com.mycompany.thebattleships;

public class Ship {
    byte startRow;
    byte startColumn;
    int size;
    boolean isHorizontal;

    public Ship(byte row, byte column, byte eSize, boolean horizontal){
        this.startRow = row;
        this.startColumn = column;
        this.size = eSize;
        this.isHorizontal = horizontal;
    }
}
