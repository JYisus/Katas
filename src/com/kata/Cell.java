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

    public void kill() throws IllegalStateException {
        if (status == 0) throw new IllegalStateException("You can't kill a dead cell");
        status = 0;
    }

    public void revive() throws IllegalStateException {
        if (status == 1) throw new IllegalStateException("You can't revive a living cell");
        status = 1;
    }

    @Override
    public String toString() {
        if(status == 1) return "x";
        return "·";
    }
}
