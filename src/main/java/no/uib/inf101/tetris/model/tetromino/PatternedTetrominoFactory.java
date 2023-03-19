package no.uib.inf101.tetris.model.tetromino;


public class PatternedTetrominoFactory implements TetrominoFactory {
    private String pattern;
    private int index = 0 ;
    
    public PatternedTetrominoFactory(String pattern) {
        this.pattern = pattern;
        this.index = 0;
    }
    
    public Tetromino getNext() {
        char c = pattern.charAt(index);
        index = (index + 1) % pattern.length();
        return Tetromino.newTetromino(c);
    }
    
}
