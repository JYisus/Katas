package com.kata;

public class Grid {
    private Cell[][] cells;

    Grid(int files, int columns) throws IllegalArgumentException {
        if ((files <= 0) || (columns <= 0)) throw new IllegalArgumentException("Can't create a grid with <= 0 files or columns");

        InitializeCells(files, columns);
    }

    private void InitializeCells(int files, int columns) {
        this.cells = new Cell[files][columns];
        for (int i = 0; i < files; i++) {
            for(int j = 0; j < columns; j++) {
                this.cells[i][j] = new Cell(0);
            }
        }
    }

    public int getFiles() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int file, int column) throws ArrayIndexOutOfBoundsException {
        return cells[file][column];
    }
}
