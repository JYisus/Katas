package com.kata;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    public void a_dead_cell_is_created() {
        Cell cell = new Cell(0);
        assertEquals(0, cell.getStatus(), "A dead cell is created");
    }

    @Test
    public void a_living_cell_is_created() {
        Cell cell = new Cell(1);
        assertEquals(1, cell.getStatus(), "A living cell is created");
    }

    @Test
    public void a_dead_cell_is_correctly_represented() {
        Cell cell = new Cell(0);
        assertEquals("·", cell.toString(), "The dead cell is represented correctly by the character ·");
    }

}