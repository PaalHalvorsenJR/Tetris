package no.uib.inf101.tetris;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

import no.uib.inf101.tetris.model.tetromino.GameState;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;

import no.uib.inf101.tetris.view.ViewableTetrisModel;

import no.uib.inf101.tetris.controller.ControllableTetrisModel;



public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel{

    private final TetrisBoard board;
    private final TetrominoFactory tetrominoFactory;
    private Tetromino currentTetromino;
    private GameState gameState;
    private int score = 0;
    private int tickInterval = 1000;
    


    public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory) {
        this.board = board;
        this.tetrominoFactory = tetrominoFactory;
        this.currentTetromino = tetrominoFactory.getNext(); 
        currentTetromino = currentTetromino.shiftedToTopCenterOf(board);
        gameState = GameState.ACTIVE_GAME;  
    }


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
    // Spillet er over når det ikke er plass til å hente en ny fallende brikke.

    public boolean dropTetromino(){
        int tempScore = 0;
        while (moveTetromino(1, 0));{}

            placeTetromino();
            tempScore = board.removeFullRows();
            lol(tempScore);
            score();
            callNewTetromino();
            return true;
            
    }

    public void placeTetromino(){
        for (GridCell<Character> cell : currentTetromino){
            CellPosition pos = cell.pos();
            board.set(pos, cell.value());
        } 
    } 

    public int score(){
        return this.score;
    }


    private void lol(int i){ 
        score += i * i * 100;
            if (score >= 100){
            this.tickInterval -= 500;
            tickInterval = Math.max(tickInterval, 100);
        }
    }

    private void callNewTetromino() {
        Tetromino newFallingTetromino = tetrominoFactory.getNext();
        newFallingTetromino = newFallingTetromino.shiftedToTopCenterOf(board);
        if (isLegalMove(newFallingTetromino)) {
            currentTetromino = newFallingTetromino;
            return;
        }
            else {  
            // Spillet er over når det ikke er plass til å hente en ny fallende brikke.
            gameState = GameState.GAME_OVER;
        } 
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
        return currentTetromino;
    }    

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public boolean isGameOver() {
        return gameState == GameState.GAME_OVER;
    }

    @Override
    public int getTickIntervalMilliseconds() {
        return tickInterval;
    }
    //hver gang poengene øker med 1000, skal tetris-tiden gå ned med 900 millisekunder.
    @Override
    public void clockTick() {
        if(!moveTetromino(1, 0)){
            placeTetromino();
            board.removeFullRows();
            callNewTetromino();
            }
        }
        
}
    


