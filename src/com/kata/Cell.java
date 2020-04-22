package com.kata;

public class Cell {
    private int status;

    Cell(int status) throws IllegalArgumentException {
        if ((status != 0) && (status != 1)) throw new IllegalArgumentException("Not valid status for a cell");
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
