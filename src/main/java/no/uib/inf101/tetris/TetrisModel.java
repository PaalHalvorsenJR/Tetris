package no.uib.inf101.tetris;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;
import no.uib.inf101.tetris.view.ViewableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.Tetromino;

public class TetrisModel implements ViewableTetrisModel {
    private final TetrisBoard board;
    private final TetrominoFactory tetrominoFactory;
    private Tetromino tetromino;
    private Tetromino fallingTetromino;


    public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory) {
        this.board = board;
        this.tetrominoFactory = tetrominoFactory;
        this.tetromino = tetrominoFactory.getNext();
        tetromino = tetromino.shiftedToTopCenterOf(board);
        
    }



    private void callNewTetromino() {
        Tetromino newTetromino = tetrominoFactory.getNext();
        newTetromino = newTetromino.shiftedToTopCenterOf(board);
    }
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
        return tetromino;
    }    


}
