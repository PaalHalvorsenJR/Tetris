package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.model.tetromino.GameState;

/**
*The ControllableTetrisModel interface defines methods for controlling and managing the Tetris game model.
*/

public interface ControllableTetrisModel {

    /**
    *Moves the current tetromino by deltaRow rows and deltaCol columns.
    *@param deltaRow The number of rows to move the tetromino by.
    *@param deltaCol The number of columns to move the tetromino by.
    *@return true if the move is valid and the tetromino was moved, false otherwise.
    */
    boolean moveTetromino(int deltaRow, int deltaCol);

    /**
    *Rotates the current tetromino.
    *@return true if the tetromino was rotated, false otherwise.
    */
    boolean rotateTetromino();

    /**
    *Drops the current tetromino to the bottom of the board.
    *@return true if the tetromino was dropped, false otherwise.
    */
    boolean dropTetromino();

    /**
    *Checks if the game is over.
    *@return true if the game is over, false otherwise.
    */
    boolean isGameOver();

    /**
    *Gets the number of milliseconds between each clock tick.
     * @return The number of milliseconds between each clock tick.
    */
    int getTickIntervalMilliseconds();

    /**
    *Gets the current state of the game.
    *@return The current state of the game.
    */
    GameState getGameState();

    /**
    *Called every time the clock ticks.
    */

    void clockTick();

    /**
    *sets the game state to paused.
    */

    void pauseGame();

    /**
     * sets the game state to active when paused is.
     */
    void startGame();

    /**
     * sets the game state to over.
     */
    int score();

    /**
     * start face of the game 
     */
    void Welcome();


}

