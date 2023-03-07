package no.uib.inf101.tetris;

import javax.swing.JFrame;

import no.uib.inf101.tetris.view.TetrisView;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.tetris.controller.TetrisController;
import no.uib.inf101.tetris.model.tetromino.RandomTetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;



public class TetrisMain {
  public static final String WINDOW_TITLE = "INF101 Tetris";
  
  public static void main(String[] args) {
    TetrisBoard board = new TetrisBoard(20, 10);
    board.set(new CellPosition(0, 0), 'L');
    board.set(new CellPosition(0, 9), 'J');
    board.set(new CellPosition(19, 0), 'Z');
    board.set(new CellPosition(19, 9), 'I');
    TetrominoFactory factory = new RandomTetrominoFactory();
    TetrisModel model = new TetrisModel(board, factory);
    TetrisView tetrisView = new TetrisView(model);
    TetrisController controller = new TetrisController(model, tetrisView);


    // The JFrame is the "root" application window.
    // We here set som properties of the main window, 
    // and tell it to display our tetrisView
    JFrame frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Here we set which component to view in our window
    frame.setContentPane(tetrisView);

    frame.addKeyListener(controller);
    
    // Call these methods to actually display the window
    frame.pack();
    frame.setVisible(true);
  }
}

