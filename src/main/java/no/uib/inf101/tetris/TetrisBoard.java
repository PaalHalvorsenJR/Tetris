package no.uib.inf101.tetris;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

/**
 * The TetrisBoard class represents the board of the game.
 * it is a subclass of Grid<Character> and has a method to check if a row is full.
 */

public class TetrisBoard extends Grid<Character> {
    // The number of rows removed.
    private int rowsRemoved = 0;

    /**
     * Constructs a TetrisBoard object with the specified number of rows and columns.
     * All cells are initialized to the default character ('-').
     * @param rows the number of rows on the board.
     * @param cols the number of columns on the board.
     */
    public TetrisBoard(int rows, int cols) {
        super(rows, cols, '-');
    }

    /**
     * Returns a string representation of the board, with each row on a new line.
     * @return a string representation of the board.
     */
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

    /**
     * Checks if a specified character exists in the specified row.
     * @param row the row to search.
     * @param c the character to look for.
     * @return true if the character exists in the row, false otherwise.
     */
    public boolean elementExists(int row, char c){
        for (int i = 0; i < cols(); i++) {
            if (get(new CellPosition(row, i)) == c) {
                return true;
            }
        } return false;
    }

    /**
     * Sets all cells in a specified row to a specified character.
     * @param row the row to set.
     * @param c the character to set the row to.
     */
    public void setAllValuesRow(int row, char c) {
        for (int i = 0; i < cols(); i++) {
            set(new CellPosition(row, i), c);
        }
    }

    /**
     * Copies all cells in one row to another row.
     * @param row the row to copy.
     * @param row2 the row to copy to.
     */
    public void copyAllValuesRow(int row, int row2) {
        for (int i = 0; i < cols(); i++) {
            set(new CellPosition(row2, i), get(new CellPosition(row, i)));
            
        }
    }

    /**
     * Removes all full rows from the board and shifts the rows above down.
     * @return the number of rows that were removed.
     */
    public int removeFullRows() {
        int rowsRemoved = 0;
        int a = rows() - 1;
        int b = rows() - 1;
        
        while (a >= 0) {
            while (b >= 0 && elementExists(b, '-') == false) {
                rowsRemoved++;
                b--;
            }
            
            if (b >= 0) {
                copyAllValuesRow(b, a);
            } else {
                setAllValuesRow(a, '-');
            }
            
            a--;
            b--;
        }

        this.rowsRemoved += rowsRemoved;
    
        return rowsRemoved;


    }

    /**
     * Gets the number of rows removed from the board.
     * @return the number of rows removed from the board.
     */
    public int getRowsRemoved() {
        return rowsRemoved;
    }
}


