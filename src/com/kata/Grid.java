package com.kata;

public class Grid {
    private Cell[][] cells;

    Grid(int files, int columns) throws IllegalArgumentException {
        if ((files <= 0) || (columns <= 0)) throw new IllegalArgumentException("Can't create a grid with <= 0 files or columns");

        Cell cellsMatrix[][] = new Cell[files][columns];
        for (int i = 0; i < files; i++) {
            for(int j = 0; j < columns; j++) {
                cellsMatrix[i][j] = new Cell(0);
            }
        }

        this.cells = cellsMatrix;
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
}
