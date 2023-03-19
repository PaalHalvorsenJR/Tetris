package no.uib.inf101.tetris.model.tetromino;

public class RandomTetrominoFactory implements TetrominoFactory {

    /**
     * The characters that can be used to create tetrominos.
     */
    private char[] c = {'L', 'J', 'S', 'Z', 'T', 'I', 'O'};

    @Override
    public Tetromino getNext() {
        return Tetromino.newTetromino(c[(int) (Math.random() * c.length)] );
    }
}


    

