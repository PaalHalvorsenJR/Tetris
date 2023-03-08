package no.uib.inf101.tetris.controller;

public interface ControllableTetrisModel {
    /**
     * Flytter tetrominoen med deltaRow rader og deltaCol kolonner.
     * @return true hvis flyttingen var gyldig og tetrominoen ble flyttet, ellers false.
     */
    boolean moveTetromino(int deltaRow, int deltaCol);
    /**
     * Roterer tetrominoen.
     * @return true hvis tetrominoen ble rotert, ellers false.
     */
    boolean rotateTetromino();
    /**
     * Flytter tetrominoen ned til bunnen av brettet.
     * @return true hvis tetrominoen ble flyttet, ellers false.
     */
    boolean dropTetromino();
    /**
     * @return true hvis spillet er ferdig, ellers false.
     */
    boolean isGameOver();

}