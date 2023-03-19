package no.uib.inf101.tetris.view;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.tetromino.GameState;

/**
 * The ViewableTetrisModel interface defines the methods that a class must implement to be a ViewableTetrisModel.
 */
public interface ViewableTetrisModel {

    /**
     * Returns the dimension of the board.
     * @return
     */
    public GridDimension getDimension();

    /**
     * returns the tiles on the board.
     * @return
     */
    public Iterable<GridCell<Character>> getTilesOnBoard();

    /**
     * returns the tiles on the tetromino.
     * @return
     */
    public Iterable<GridCell<Character>> getTilesOnTetromino();

    /**
     * returns the game state.
     * @return
     */
    public GameState getGameState();

}


