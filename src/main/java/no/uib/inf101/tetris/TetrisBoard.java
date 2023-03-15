package no.uib.inf101.tetris;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character> {
    private int rowsRemoved = 0;

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

    public boolean elementExists(int row, char c){
        for (int i = 0; i < cols(); i++) {
            if (get(new CellPosition(row, i)) == c) {
                return true;
            }
        } return false;
    }

    public void setAllValuesRow(int row, char c) {
        for (int i = 0; i < cols(); i++) {
            set(new CellPosition(row, i), c);
        }
    }

    public void copyAllValuesRow(int row, int row2) {
        for (int i = 0; i < cols(); i++) {
            set(new CellPosition(row2, i), get(new CellPosition(row, i)));
            
        }
    }

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

    public int getRowsRemoved() {
        return rowsRemoved;
    }








   
    
//   public boolean elementExists(int row, int col) {
//         for (int i = 0; i < rows(); i++) {
//             for (int j = 0; j < cols(); j++) {
//                 if (row == i && col == j) {
//                     return true;
//                 }
//             }
//         } return false;
//     }


//     public void copyAllValues(TetrisBoard board) {
//         for (int i = 0; i < rows(); i++) {
//             for (int j = 0; j < cols(); j++) {
//                 set(new CellPosition(i, j), board.get(new CellPosition(i, j)));
//             }
//         }
//     }

//     public void removeRow(int row) {
//         for (int j = 0; j < cols(); j++) {
//             set(new CellPosition(row, j), '-');
//         }
//     }
    
//     public int removeFullRows() {
//         int rowsRemoved = 0;
//         for (int i = rows() - 1; i >= 0; i--) { // start at bottom row and go up
//             boolean isRowFull = true;
//             for (int j = 0; j < cols(); j++) {
//                 if (!elementExists(i, j) || get(new CellPosition(i, j)) == '-') {
//                     isRowFull = false;
//                     break;
//                 }
//             }
//             if (isRowFull) { // remove row and shift all rows above it down
//                 for (int k = i; k > 0; k--) {
//                     for (int j = 0; j < cols(); j++) {
//                         set(new CellPosition(k, j), get(new CellPosition(k - 1, j)));
//                     }
//                 }
//                 // add new empty row at the top
//                 for (int j = 0; j < cols(); j++) {
//                     set(new CellPosition(0, j), '-');
//                 }
//                 rowsRemoved++;
//                 // check same row again, since rows have been shifted down
//                 i++;
//             }
//         }
//         return rowsRemoved;
// }

}


