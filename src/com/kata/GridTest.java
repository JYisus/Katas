package com.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private Grid grid = new Grid(5,10);

    @DisplayName("Grid is created")
    @Test
    public void gridCreation() {
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
        assertEquals(5, grid.getFiles(),"Files correctly created");
    }

    @DisplayName("Grid have correct columns")
    @Test
    public void correctNumberOfColumns() {
        assertEquals(10, grid.getColumns(),"Columns correctly created");
    }

    @DisplayName("A cell matrix is created with the grid")
    @Test
    public void cellMatrixIsCreated() {
        assertNotNull(grid.getCells());
    }
    @DisplayName("The cells matrix have correct files")
    @Test
    public void cellMatrixIsCreatedWithIndicatedFiles() {
        assertEquals(5, grid.getCells().length);
    }

    @DisplayName("A cell is getted from the grid")
    @Test
    public void getCellFromGrid() {
        assertNotNull(grid.getCell(0, 1));
    }

    @DisplayName("Can't access to invalid cell of grid")
    @Test
    public void getInvalidCell() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            grid.getCell(-2,10);
        });
    }

    @DisplayName("A Cell is set to live")
    @Test
    public void setCellToLive() {
        grid.setLivingCell(0,1);
        assertEquals(1, grid.getCell(0,0).getStatus());
    }

    @DisplayName("Can't set to live cell out of index")
    @Test
    public void setLivingInvalidCell() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            grid.setLivingCell(-2,10);
        });
    }

    @DisplayName("An alone cell have no neighbours")
    @Test
    public void getNeighboursOfAloneCell() {
        int neighbours = grid.getNeighbours(0,0);
        assertEquals(0, neighbours);
    }

    @DisplayName("A cell near other have 1 neighbour")
    @Test
    public void getNeighboursOf2NearCells() {
        grid.setLivingCell(0,1);
        int neighbours = grid.getNeighbours(0,0);
        assertEquals(1, neighbours);
    }
}