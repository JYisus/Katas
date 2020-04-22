package com.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @DisplayName("Grid is created")
    @Test
    public void gridCreation() {
        Grid grid = new Grid(5,5);
        assertNotNull(grid, "The grid is created");
    }

    @DisplayName("Can't create a grid with <= 0 files or columns")
    @Test
    public void invalidGridCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Grid(0,-5);
        });

    }

    @DisplayName("Grid have correct files")
    @Test
    public void correctNumberOfFiles() {
        Grid grid = new Grid(5,10);
        assertEquals(5, grid.getFiles(),"Files correctly created");
    }

    @DisplayName("Grid have correct columns")
    @Test
    public void correctNumberOfColumns() {
        Grid grid = new Grid(5,10);
        assertEquals(10, grid.getColumns(),"Columns correctly created");
    }

    @DisplayName("A cell matrix is created with the grid")
    @Test
    public void cellMatrixIsCreated() {
        Grid grid = new Grid(5, 10);
        assertNotNull(grid.getCells());
    }
    @DisplayName("The cells matrix have correct files")
    @Test
    public void cellMatrixIsCreatedWithIndicatedFiles() {
        Grid grid = new Grid(5, 10);
        assertEquals(5, grid.getCells().length);
    }

    @DisplayName("A cell is getted from the grid")
    @Test
    public void getCellFromGrid() {
        Grid grid = new Grid(5, 10);
        assertNotNull(grid.getCell(0, 1));
    }

    @DisplayName("Can't access to invalid cell of grid")
    @Test
    public void getInvalidCell() {
        Grid grid = new Grid(5, 10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            grid.getCell(-2,10);
        });
    }
}