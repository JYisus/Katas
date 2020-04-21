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

    @DisplayName("Grid have correct files")
    @Test
    public void correctNumberOfFiles() {
        Grid grid = new Grid(5,5);
        assertEquals(5, grid.getFiles(),"Files correctly created");
    }

    @DisplayName("Grid have correct columns")
    @Test
    public void correctNumberOfColumns() {
        Grid grid = new Grid(5,5);
        assertEquals(5, grid.getColumns(),"Columns correctly created");
    }

}