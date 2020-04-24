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

    public void setLivingCell(int file, int column) throws ArrayIndexOutOfBoundsException {
        getCell(file, column).revive();
    }

    public void clean() {
        for(Cell[] cellFile : cells){
            for(Cell cell : cellFile) {
                if(cell.getStatus() == 1) {
                    cell.kill();
                }
            }
        }
    }

    public int getNeighbours(int file, int column) throws ArrayIndexOutOfBoundsException {
        int neighbours = 0;
        for(int i = -1; i <= 1; i++) {
            if (column+i < 0) continue;
            for(int j = -1; j <= 1; j++) {
                if (file+j < 0 || (j == 0 && (i == 0))) continue;
                if(cells[file+i][column+j].getStatus() == 1) {
                    neighbours++;
                }
            }
        }

        return neighbours;
    }
}
