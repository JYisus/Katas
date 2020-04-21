package com.kata;

public class Cell {
    private int status;

    Cell(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    // TODO: Exception should be thrown if cell is already dead
    public void kill() {
        status = 0;
    }

    // TODO: Exception should be thrown if cell is already living
    public void revive() {
        status = 1;
    }

    @Override
    public String toString() {
        if(status == 1) return "x";
        return "·";
    }
}
