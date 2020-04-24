package com.kata;

import javax.swing.event.CellEditorListener;

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
            if (file+i < 0 || file+i >= cells.length) continue;
            for(int j = -1; j <= 1; j++) {
                if (column+j < 0 || column+j >= cells[file+i].length || (j == 0 && (i == 0))) continue;
                if(cells[file+i][column+j].getStatus() == 1) {
                    neighbours++;
                }
            }
        }

        return neighbours;
    }

    public void nextState() {
        Grid newGrid = this;
        Cell[][] nextCells = new Cell[getFiles()][getColumns()];

        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                if((getNeighbours(i, j) < 2) && (cells[i][j].getStatus() == 1)) {
                    nextCells[i][j] = new Cell(0);
                    continue;
                }
                if((getNeighbours(i, j) > 3) && (cells[i][j].getStatus() == 1)) {
                    nextCells[i][j] = new Cell(0);
                    continue;
                }
                if((getNeighbours(i, j) == 3) && (cells[i][j].getStatus() == 0)) {
                    nextCells[i][j] = new Cell(1);
                    continue;
                }
                if(cells[i][j].getStatus() == 1) {
                    nextCells[i][j] = new Cell(1);
                } else {
                    nextCells[i][j] = new Cell(0);
                }
            }
        }

        this.cells = nextCells;
    }

    @Override
    public String toString() {
        String gridString = "Grid   " + getFiles() + "x" + getColumns() + "\n";
        for(Cell[] cellFiles : cells) {
            for(Cell cell : cellFiles) {
                gridString+=cell;
            }
            gridString+="\n";
        }
        return gridString;
    }
}
