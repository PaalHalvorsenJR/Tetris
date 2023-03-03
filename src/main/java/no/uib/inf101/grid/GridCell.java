package no.uib.inf101.grid;

public record GridCell<E>(CellPosition pos, E value) {

    public E get(int col) {
        return null;
    }
    
    public void set(int col, E value2) {
    }

}
