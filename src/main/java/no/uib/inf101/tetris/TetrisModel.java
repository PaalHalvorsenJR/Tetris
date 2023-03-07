package no.uib.inf101.tetris;

import javax.swing.text.AttributeSet.ColorAttribute;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;

import no.uib.inf101.tetris.view.ViewableTetrisModel;

import no.uib.inf101.tetris.controller.ControllableTetrisModel;


public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel{

    private final TetrisBoard board;
    private final TetrominoFactory tetrominoFactory;
    private Tetromino currentTetromino;

    public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory) {
        this.board = board;
        this.tetrominoFactory = tetrominoFactory;
        this.currentTetromino = tetrominoFactory.getNext().shiftedToTopCenterOf(board);
    }

    @Override
    public boolean moveTetromino(int deltaRow, int deltaCol) {
        Tetromino newTetromino = currentTetromino.shiftedBy(deltaRow, deltaCol);
        if (isLegalMove(newTetromino)){
            currentTetromino = newTetromino;
            return true;
        }
        return false;
    }

    public boolean isLegalMove(Tetromino tetromino){
        for (GridCell<Character> cell : tetromino){
            CellPosition pos = cell.pos();
            if (!board.positionIsOnGrid(pos) || board.get(pos) != '-'){
                return false;
            }
        }
        return true;
    }
    public boolean rotateTetromino(){
        Tetromino newTetromino = currentTetromino.rotate();
        if (isLegalMove(newTetromino)){
            currentTetromino = newTetromino;
            return true;
        }
        return false;
    }

    public boolean dropTetromino(){
        while (moveTetromino(1, 0)){
        }
        placeTetromino();
        currentTetromino = tetrominoFactory.getNext().shiftedToTopCenterOf(board);
        return true;
        
    }


    public void placeTetromino(){
        for (GridCell<Character> cell : currentTetromino){
            CellPosition pos = cell.pos();
            board.set(pos, cell.value());
        }
    }
    

    

    // private void callNewTetromino() {
    //     Tetromino newTetromino = tetrominoFactory.getNext();
    //     newTetromino = newTetromino.shiftedToTopCenterOf(board);
    // }

// Hint: når du skal implementere metoden som returnerer noe med typen GridDimension som inneholder antall rader og kolonner -- har du tilfeldigvis et objekt med denne typen allerede som du enkelt kan returnere? :think:
    @Override
    public GridDimension getDimension(){ 
        return board;
    };
    // når du skal implementere metoden som returnerer en Iterable<CoordinateItem<Tile>> som kan iterere over flisene på brettet -- har du tilfeldigvis et objekt med denne typen allerede som du enkelt kan returnere? :think:
    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return board;
    }
    @Override
    public Iterable<GridCell<Character>> getTilesOnTetromino() {
        return currentTetromino;
    }    
}


