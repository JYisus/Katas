package com.kata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell deadCell = new Cell(0);
    private Cell livingCell = new Cell(1);

    @DisplayName("Dead cell is created")
    @Test
    public void a_dead_cell_is_created() {
        assertEquals(0, deadCell.getStatus(), "A dead cell is created");
    }

    @DisplayName("Living cell is created")
    @Test
    public void a_living_cell_is_created() {
        assertEquals(1, livingCell.getStatus(), "A living cell is created");
    }

    @DisplayName("Dead cell is represented")
    @Test
    public void a_dead_cell_is_correctly_represented() {
        assertEquals("·", deadCell.toString(), "The dead cell is represented correctly by the character ·");
    }

    @DisplayName("Living cell is created")
    @Test
    public void a_living_cell_is_correctly_represented() {
        assertEquals("x", livingCell.toString(), "The dead cell is represented correctly by the character x");
    }

}