package no.uib.inf101.grid;


import java.util.ArrayList;
import java.util.Iterator;

public class Grid<E> implements IGrid<E> {
    ArrayList<GridCell<E>> grid = new ArrayList<>();
    private int rows;
    private int cols;

    

    // konstruktør #1 
    public Grid(int rows, int cols) {
        this (rows, cols, null);
    }
    // konstruktør #2 (med defaultverdi)
    // denne kan kalle konstruktør #1
    // og så sette alle cellene til defaultverdien
    public Grid(int rows, int cols, E defaultValue) {
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < rows * cols; i++) {
            grid.add(new GridCell<E>(new CellPosition(i / cols, i % cols), defaultValue));
        }
    }
    // metode som returnerer antall rader
    @Override
    public int rows() {
        return rows;

    }
    // metode som returnerer antall kolonner
    @Override
    public int cols() {
        return cols;

    }
    // metode som returnerer en iterator over alle cellene
    @Override
    public Iterator<GridCell<E>> iterator() {
        return grid.iterator();
    }
    // metode som returnerer en iterator over alle cellene i en gitt rad
    @Override
    public void set(CellPosition pos, E value) {
       grid.set(pos.row() * cols + pos.col(), new GridCell<E>(pos, value));


    }

    @Override
    public E get(CellPosition pos) {
        return grid.get(pos.row() * cols + pos.col()).value();
    }

    @Override
    public boolean positionIsOnGrid(CellPosition pos) {
        if (pos.row() < 0 || pos.row() >= rows || pos.col() < 0 || pos.col() >= cols) {
            return false;
        }
        return true;
    }

}