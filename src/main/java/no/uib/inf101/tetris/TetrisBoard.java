package no.uib.inf101.tetris;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;



public class TetrisBoard extends Grid<Character> {
    public TetrisBoard(int rows, int cols) {
        super(rows, cols, '-');
    }


public String prettyString() {
    String prettyString = "";
    for (int i = 0; i < rows(); i++) {
        for (int j = 0; j < cols(); j++) {
            prettyString += get(new CellPosition(i, j));
        }
        if (i < rows() - 1) {
            prettyString += "\n";
        }

    }
    return prettyString;

    }
}

