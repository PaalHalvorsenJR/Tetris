package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.model.tetromino.Tetromino;

public class TetrisController implements ControllableTetrisModel {
    
        @Override
        public boolean moveTetromino(int deltaRow, int deltaCol) {
            Tetromino t = fallingTetromino.shiftedBy(deltaRow, deltaCol);

    }
    
}
