package com.kata;

public class GameOfLife {
    Grid gameGrid;

    GameOfLife() {
        gameGrid = new Grid(15, 100);
        gameGrid.setLivingCell(1,1);
        gameGrid.setLivingCell(1,2);
        gameGrid.setLivingCell(3,1);
        gameGrid.setLivingCell(2,1);

        gameGrid.setLivingCell(7,22);
        gameGrid.setLivingCell(7,25);
        gameGrid.setLivingCell(6,22);
        gameGrid.setLivingCell(5,22);
        gameGrid.setLivingCell(6,24);
        gameGrid.setLivingCell(5,23);
    }

    private void showGrid() {
        System.out.println(gameGrid);
    }

    public void start() {
        showGrid();
        while(true) {
            gameGrid.nextState();
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[2J");
            showGrid();
        }
    }

}
