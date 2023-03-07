package no.uib.inf101.tetris.controller;

public interface ControllableTetrisModel {
    /**
     * Flytter tetrominoen med deltaRow rader og deltaCol kolonner.
     * @return true hvis flyttingen var gyldig og tetrominoen ble flyttet, ellers false.
     */
    boolean moveTetromino(int deltaRow, int deltaCol);

    boolean rotateTetromino();

    boolean dropTetromino();

}