package com.kata;

public class Cell {
    static final int DEAD_STATUS = 0;
    static final int LIVING_STATUS = 1;

    private int status;

    Cell(int status) throws IllegalArgumentException {
        if ((status != DEAD_STATUS) && (status != LIVING_STATUS)) throw new IllegalArgumentException("Not valid status for a cell");
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void kill() throws IllegalStateException {
        if (status == DEAD_STATUS) throw new IllegalStateException("You can't kill a dead cell");
        status = DEAD_STATUS;
    }

    public void revive() throws IllegalStateException {
        if (status == LIVING_STATUS) throw new IllegalStateException("You can't revive a living cell");
        status = LIVING_STATUS;
    }

    @Override
    public String toString() {
        if(status == LIVING_STATUS) return "x";
        return "·";
    }
}
