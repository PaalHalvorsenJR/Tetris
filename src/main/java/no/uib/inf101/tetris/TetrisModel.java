package no.uib.inf101.tetris;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

import no.uib.inf101.tetris.model.tetromino.GameState;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;

import no.uib.inf101.tetris.view.ViewableTetrisModel;

import no.uib.inf101.tetris.controller.ControllableTetrisModel;


/**
 * The TetrisModel class implements the ViewableTetrisModel and ControllableTetrisModel interfaces.
 * It is the model of the tetris game.
 */

public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel{
    //Filds for the class
    private final TetrisBoard board;
    private final TetrominoFactory tetrominoFactory;
    private Tetromino currentTetromino;
    private GameState gameState;
    private int score = 0;
    private int tickInterval;
    private int level;
    

    /**
     * Creates a new TetrisModel with the given TetrisBoard and TetrominoFactory.
     * @param board The TetrisBoard to use.
     * @param tetrominoFactory The TetrominoFactory to use.
     * 
     */
    public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory) {
        this.board = board;
        this.tetrominoFactory = tetrominoFactory;
        this.currentTetromino = tetrominoFactory.getNext(); 
        currentTetromino = currentTetromino.shiftedToTopCenterOf(board);
        // tickinterval starts at 1000, and decreases by 500 each time score increases by 100
        this.tickInterval = 0;
        this.level = 0;

        gameState = GameState.ACTIVE_GAME; 

        tickInterval = calculateTickInterval(level);
        levels();

        }
        
        // gameState = GameState.ACTIVE_GAME;  

    /**
    *Moves the current tetromino by the given row and column delta.
    *@param deltaRow The number of rows to move.
    *@param deltaCol The number of columns to move.
    *@return True if the move is legal and successful, false otherwise.
    */
    public boolean moveTetromino(int deltaRow, int deltaCol) {
        Tetromino newTetromino = currentTetromino.shiftedBy(deltaRow, deltaCol);
        if (isLegalMove(newTetromino)){
            currentTetromino = newTetromino;
            return true;
        } 

        return false;
    }

    /**
    *Checks if the given tetromino is a legal move.
    *@param tetromino The tetromino to check.
    *@return True if the move is legal, false otherwise.
    */
    public boolean isLegalMove(Tetromino tetromino){
        for (GridCell<Character> cell : tetromino){
            CellPosition pos = cell.pos();
            if (!board.positionIsOnGrid(pos) || board.get(pos) != '-'){
                return false;
            }
        }
        return true;
    }

    /**
    *Rotates the current tetromino.
    *@return True if the rotation is legal and successful, false otherwise.
    */
    public boolean rotateTetromino(){
        Tetromino newTetromino = currentTetromino.rotate();
        if (isLegalMove(newTetromino)){
            currentTetromino = newTetromino;
            return true;
        }
        return false;
    }

    /**
    *Drops the current tetromino to the bottom of the board.
    *Use a while loop to call moveTetromino() until it returns false.
    *Then call ScoreSystem().
    *Then call placeTetromino() and callNewTetromino().
    *Finally, return true.
    *@return True if the drop is successful, false otherwise.
    */
    public boolean dropTetromino(){
        int tempScore = 0;
        while (moveTetromino(1, 0)){}
            placeTetromino();
            tempScore = board.removeFullRows();
            scoreSystem(tempScore);
            score();
            levels();
            callNewTetromino();
            System.out.println(level);
            System.out.println(tickInterval);
            return true;
    }

    private int calculateTickInterval(int level) {
        return Math.max (100, 1000 - (level - 1) * 500);
    }

    private void updateTickInterval() {
        tickInterval = calculateTickInterval(level);
    }

    public void levels(){
        if (score() < 100 ) {
            this.level = 1;
        }
        else if (score() >= 100 && score() < 200) {
            this.level = 2;
        }
        else if (score() >= 200 && score() < 300) {
            this.level = 3;
        }
       updateTickInterval();

    }
    /**
    Places the current tetromino on the board.
    */
    public void placeTetromino(){
        for (GridCell<Character> cell : currentTetromino){
            CellPosition pos = cell.pos();
            board.set(pos, cell.value());
        } 
    } 

    /**
    Gets the current score.
    @return The current score.
    */

    public int score(){
        return this.score;
    }

    /**
     * calculate the score system.
     * @param tempScore
     */
    public void scoreSystem(int tempScore){
        score += tempScore * tempScore * 100;
    }
 
    /**
     * Method for getting a new tetromino.
     * use shiftToTopCenterOf() to get the tetromino to the top center of the board.
     */
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

    
    public int getTickIntervalMilliseconds() {
        return tickInterval;
    }
    //hver gang poengene øker med 1000, skal tetris-tiden gå ned med 900 millisekunder.
    
    public void clockTick() {
        if(!moveTetromino(1, 0)){
            placeTetromino();
            board.removeFullRows();
            callNewTetromino();
            }
        }
    @Override
    public void pauseGame() {
        if (gameState == GameState.ACTIVE_GAME)
            gameState = GameState.PAUSED;
    }

    @Override
    public void startGame() {
        if (gameState == GameState.PAUSED)
            gameState = GameState.ACTIVE_GAME;
    }

}

