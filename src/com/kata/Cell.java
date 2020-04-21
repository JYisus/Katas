package com.kata;

public class Cell {
    private int status;

    Cell(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        if(status == 1) return "x";
        return "·";
    }
}
