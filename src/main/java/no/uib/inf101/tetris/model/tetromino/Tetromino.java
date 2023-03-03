package no.uib.inf101.tetris.model.tetromino;

import javax.swing.plaf.synth.SynthPanelUI;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;


public final class Tetromino {
    private char c;
    private Boolean[][] shape;
    private CellPosition pos;


    private Tetromino(char c, Boolean[][] shape, CellPosition pos) {
        this.c = c;
        this.shape = shape;
        this.pos = pos;


    }

    private static Tetromino newTetromino(char c) {
        if (c == 'I'){
            return new Tetromino(c, new Boolean[][]{    
            {true, true, true},
            {true, true, true},
            {true, true, true}},
            null 
            );
        }
        else if (c == 'J'){
            return new Tetromino(c, new Boolean[][]{    
            {true, true, true},
            {true, true, true},
            {true, true, true}},
            null 
            );
        }
        else if (c == 'L'){
            return new Tetromino(c, new Boolean[][]{    
            {true, true, true},
            {true, true, true},
            {true, true, true}},
            null 
            );
        }
        else if (c == 'O'){
            return new Tetromino(c, new Boolean[][]{    
            {true, true, true},
            {true, true, true},
            {true, true, true}},
            null 
            );
        }
        else if (c == 'S'){
            return new Tetromino(c, new Boolean[][]{    
            {true, true, true},
            {true, true, true},
            {true, true, true}},
            null 
            );
        }
        else if (c == 'T'){
            return new Tetromino(c, new Boolean[][]{    
            {true, true, true},
            {true, true, true},
            {true, true, true}},
            null 
            );
        }
        else if (c == 'Z'){
            return new Tetromino(c, new Boolean[][]{    
            {true, true, true},
            {true, true, true},
            {true, true, true}},
            null 
            );
        }

    Tetromino shiftedBy(int deltaRow, int deltaCol) {
        return new Tetromino(c, shape, pos.shiftedBy(deltaRow, deltaCol));

    }
    







} 

