package com.kata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import javax.management.InvalidAttributeValueException;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell deadCell = new Cell(0);
    private Cell livingCell = new Cell(1);

    @DisplayName("Dead cell is created")
    @Test
    public void deadCellCreation() {
        assertEquals(0, deadCell.getStatus(), "A dead cell is created");
    }

    @DisplayName("Living cell is created")
    @Test
    public void livingCellCreation() {
        assertEquals(1, livingCell.getStatus(), "A living cell is created");
    }

    @DisplayName("Cell creator throes exception when invalid status is indicated")
    @Test
    public void invalidStatusException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cell(3);
        });
    }

    @DisplayName("Dead cell is represented")
    @Test
    public void deadCellRepresentation() {
        assertEquals("·", deadCell.toString(), "The dead cell is represented correctly by the character ·");
    }

    @DisplayName("Living cell is representated")
    @Test
    public void livingCellRepresentation() {
        assertEquals("x", livingCell.toString(), "The dead cell is represented correctly by the character x");
    }

    @DisplayName("Living cell is killed")
    @Test
    public void killingLivingCell() {
        Cell cell = new Cell(1);
        cell.kill();
        assertEquals(0, cell.getStatus(), "The living cell now is dead");
    }

    @DisplayName("You can't kill a dead cell")
    @Test
    public void killingDeadCell() {
        assertThrows(IllegalStateException.class, () -> {
            deadCell.kill();
        });
    }

    @DisplayName("Dead cell comes to life")
    @Test
    public void reviveDeadCell() {
        Cell cell = new Cell(0);
        cell.revive();
        assertEquals(1, cell.getStatus(), "The dead cell now is living");
    }

    @DisplayName("You can't reviva a living cell")
    @Test
    public void reviveLivingCell() {
        assertThrows(IllegalStateException.class, () -> {
            livingCell.revive();
        });
    }

}