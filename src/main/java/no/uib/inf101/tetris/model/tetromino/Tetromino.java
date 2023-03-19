package no.uib.inf101.tetris.model.tetromino;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;


/**
 * A tetromino is a 4x4 grid of cells, where some cells are filled and some are empty.
 * The tetromino has a position, which is the position of the top-left cell.
 * The tetromino has a shape, which is a 4x4 grid of booleans, where true means filled and false means empty.
 * The tetromino has a character, which is the character used to represent the tetromino in a text-based game.
 * 
 */
public final class Tetromino implements Iterable<GridCell<Character>> {
    private char c;
    private Boolean[][] shape;
    private CellPosition pos;

    /**
     * constructor for creating a new tetromino.
     * 
     * @param c The character used to represent the tetromino in a text-based game.
     * @param shape The shape of the tetromino.
     * @param pos the position of the tetromino.
     */
    private Tetromino(char c, Boolean[][] shape, CellPosition pos) {
        this.c = c;
        this.shape = shape;
        this.pos = pos;
    }

    /**
     * Creates a new tetromino with the specified character.
     * 
     * @param c The character used to represent the tetromino in a text-based game.
     * @return A new tetromino with the specified character.
     * @throws IllegalArgumentException if the character is not one of the seven tetromino characters.
     */

    public static Tetromino newTetromino(char c) {
        if (c == 'I'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false, false},
            {true, true, true, true},
            {false, false, false, false},
            {false, false, false, false}},
            new CellPosition(0, 0)
            );
        }
        else if (c == 'J'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false},
            {true, true, true},
            {false, false, true}},
            new CellPosition(0, 0)
            );
        }
        else if (c == 'L'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false},
            {true, true, true},
            {true, false, false}},
            new CellPosition(0, 0)
            );
        
        }
        else if (c == 'O'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false, false},
            {false, true, true, false},
            {false, true, true, false},
            {false, false, false, false}},
            new CellPosition(0, 0)
            );
        }
        else if (c == 'S'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false},
            {false, true, true},
            {true, true, false}},
            new CellPosition(0, 0)
            );
        }
        else if (c == 'T'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false},
            {true, true, true},
            {false, true, false}},
            new CellPosition(0, 0)
            );
        }
        else if (c == 'Z'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false},
            {true, true, false},
            {false, true, true}},
            new CellPosition(0, 0)
            );
        }
        else {
            throw new IllegalArgumentException("Invalid character" + c);
        }
    }

    /**
     * Returns a new tetromino that is shifted by the given number of rows and columns.
     *
     * @param deltaRow the number of rows to shift the tetromino
     * @param deltaCol the number of columns to shift the tetromino
     * @return a new tetromino that is shifted by the given number of rows and columns
     */

    public Tetromino shiftedBy(int deltaRow, int deltaCol) {
        return new Tetromino(c, shape, new CellPosition(pos.row() + deltaRow, pos.col() + deltaCol));
    }

    /**
     * Returns a new tetromino that is shifted to the top center of the given grid.
     *
     * @param dim the dimension of the grid
     * @return a new tetromino that is shifted to the top center of the given grid
     */

    public Tetromino shiftedToTopCenterOf (GridDimension dim){
        return new Tetromino(c, shape, new CellPosition(-1, dim.cols() / 2 - shape.length/2));
    }

    @Override
    public Iterator<GridCell<Character>> iterator() {
        List<GridCell<Character>> cells = new ArrayList<>();
    
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == true) {
                    int gridRow = pos.row() + i;
                    int gridCol = pos.col() + j;
                    cells.add(new GridCell<>(new CellPosition(gridRow, gridCol), c));
                }
            }
        }
        return cells.iterator();
    }

    /**
     * Returns a new tetromino that is rotated 90 degrees clockwise.
     *
     * @return a new tetromino that is rotated 90 degrees clockwise
     */

    public Tetromino rotate(){
        Boolean[][] newShape = new Boolean[shape.length][shape[0].length];
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                newShape[i][j] = shape[shape.length - j - 1][i];
            }
        }
        return new Tetromino(c, newShape, pos);
    } 

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + c;
        result = prime * result + Arrays.deepHashCode(shape);
        result = prime * result + ((pos == null) ? 0 : pos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tetromino other = (Tetromino) obj;
        if (c != other.c)
            return false;
        if (!Arrays.deepEquals(shape, other.shape))
            return false;
        if (pos == null) {
            if (other.pos != null)
                return false;
        } else if (!pos.equals(other.pos))
            return false;
        return true;
    }
    

}


    





