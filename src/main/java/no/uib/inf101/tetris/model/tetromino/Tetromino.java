package no.uib.inf101.tetris.model.tetromino;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;



public final class Tetromino implements Iterable<GridCell<Character>> {
    private char c;
    private Boolean[][] shape;
    private CellPosition pos;


    private Tetromino(char c, Boolean[][] shape, CellPosition pos) {
        this.c = c;
        this.shape = shape;
        this.pos = pos;
    }

    public static Tetromino newTetromino(char c) {
        if (c == 'I'){
            return new Tetromino(c, new Boolean[][]{    
            {false, true, false},
            {false, true, false},
            {false, true, false}},
            new CellPosition(0, 0)
            );
        }
        else if (c == 'J'){
            return new Tetromino(c, new Boolean[][]{    
            {false, true, false},
            {false, true, false},
            {true, true, false}},
            new CellPosition(0, 0)
            );
        }
        else if (c == 'L'){
            return new Tetromino(c, new Boolean[][]{    
            {false, true, false},
            {false, true, false},
            {false, true, true}},
            new CellPosition(0, 0)
            );
        
        }
        else if (c == 'O'){
            return new Tetromino(c, new Boolean[][]{    
            {false, false, false},
            {false, true, true},
            {false, true, true}},
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

    public Tetromino shiftedBy(int deltaRow, int deltaCol) {
        return new Tetromino(c, shape, new CellPosition(pos.row() + deltaRow, pos.col() + deltaCol));
    }
// Opprett også en metode shiftedToTopCenterOf som har en parameter av typen GridDimension. La metoden opprette en flyttet kopi som er sentrert rundt midterste eller de to midterste kolonnene i et rutenett med de gitte dimensjonene, og som er slik at øverste reelle rute i brikken kommer på rad 0.
// not use getwidth() and getheight() because they are not in the interface
    public Tetromino shiftedToTopCenterOf (GridDimension dim){
        int row = 0;
        int col = (dim.cols() - shape[0].length) / 2;
        return new Tetromino(c, shape, new CellPosition(row, col));
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


    




