package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.view.ViewableTetrisModel;



public class TetrisModel implements ViewableTetrisModel {
    private TetrisBoard board;
    public TetrisModel(TetrisBoard board) {
        this.board = board;
    }

// Hint: når du skal implementere metoden som returnerer noe med typen GridDimension som inneholder antall rader og kolonner -- har du tilfeldigvis et objekt med denne typen allerede som du enkelt kan returnere? :think:
    @Override
    public GridDimension getDimension(){ 
        return board;
    };

    // når du skal implementere metoden som returnerer en Iterable<CoordinateItem<Tile>> som kan iterere over flisene på brettet -- har du tilfeldigvis et objekt med denne typen allerede som du enkelt kan returnere? :think:
    @Override
    public Iterable<GridCell<Character>> getTitlesOnBoard() {
        return board;

    }
    

    
}
