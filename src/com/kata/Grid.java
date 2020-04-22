package com.kata;

public class Grid {
    private int files;
    private int columns;

    Grid(int files, int columns) throws IllegalArgumentException {
        if ((files <= 0) || (columns <= 0)) throw new IllegalArgumentException("Can't create a grid with <= 0 files or columns");
        this.files = files;
        this.columns = columns;
    }

    public int getFiles() {
        return files;
    }

    public int getColumns() {
        return columns;
    }
}
