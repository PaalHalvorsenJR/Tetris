package no.uib.inf101.tetris.model;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;


import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;

import no.uib.inf101.grid.GridDimension;

import no.uib.inf101.tetris.TetrisBoard;
import no.uib.inf101.tetris.TetrisModel;
import no.uib.inf101.tetris.model.tetromino.PatternedTetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.RandomTetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;

import no.uib.inf101.tetris.view.ViewableTetrisModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTetrisModel {
    @Test
    public void initialPositionOfO() {
        TetrisBoard board = new TetrisBoard(20, 10);
        TetrominoFactory factory = new PatternedTetrominoFactory("O");
        ViewableTetrisModel model = new TetrisModel(board, factory);


        List<GridCell<Character>> tetroCells = new ArrayList<>();
        for (GridCell<Character> cell : model.getTilesOnTetromino()) {
            tetroCells.add(cell);
        }

        assertEquals(4, tetroCells.size());
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'O')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'O')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'O')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 5), 'O')));
        }

    @Test
    public void initialPositionOfI() {
        TetrisBoard board = new TetrisBoard(20, 10);
        TetrominoFactory factory = new PatternedTetrominoFactory("I");
        ViewableTetrisModel model = new TetrisModel(board, factory);
    
    
        List<GridCell<Character>> tetroCells = new ArrayList<>();
        for (GridCell<Character> cell : model.getTilesOnTetromino()) {
            tetroCells.add(cell);
        }
    
        assertEquals(4, tetroCells.size());
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'I')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'I')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 3), 'I')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 6), 'I')));
        }
    // Test for å sjekke om tetrominoen kan flyttes

    @Test
    public void testMoveTetromino() {
        TetrisBoard board = new TetrisBoard(20,10);
        RandomTetrominoFactory tetrominoFactory  = new RandomTetrominoFactory();
        TetrisModel model = new TetrisModel(board, tetrominoFactory);
    
        //retuner True hvis tetrominoen kan flyttes nedover
        assertTrue(model.moveTetromino(1, 0));

        //retuner True hvis tetrominoen kan flyttes til venstre
        assertTrue(model.moveTetromino(0, 1));

        //retuner True hvis tetrominoen kan flyttes til høyre
        assertTrue(model.moveTetromino(0, 1));




    }

    @Test
    public void testMoveTetrominoisOutOfBounds() {
        TetrisBoard board = new TetrisBoard(20,10);
        RandomTetrominoFactory tetrominoFactory  = new RandomTetrominoFactory();            
        TetrisModel model = new TetrisModel(board, tetrominoFactory);

        //retunerer False dersom tetrominoen er uten for brettet på venstre side
        assertFalse(model.moveTetromino(0, -5));
        //retunerer False dersom tetrominoen er uten for brettet på høyre side
        assertFalse(model.moveTetromino(0, 5));
        //retunerer False dersom tetrominoen er uten for brettet på toppen
        assertFalse(model.moveTetromino(-20, 0));
        //retunerer False dersom tetrominoen er uten for brettet på bunnen
        assertFalse(model.moveTetromino(20, 0));


    }

    @Test
    public void testDropTetromino() {
        TetrisBoard board = new TetrisBoard(20,10);
        RandomTetrominoFactory tetrominoFactory  = new RandomTetrominoFactory();
        TetrisModel model = new TetrisModel(board, tetrominoFactory);
    
        //retuner True hvis tetrominoen droppes ned til bunnen av brettet eller en annen tetromino
        assertTrue(model.dropTetromino());
    }




}


    



   