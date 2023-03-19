package no.uib.inf101.tetris;

import javax.swing.JFrame;

import no.uib.inf101.tetris.view.TetrisView;
import no.uib.inf101.tetris.controller.TetrisController;
import no.uib.inf101.tetris.model.tetromino.RandomTetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;


/**
 * The main class for the Tetris game.
 */
public class TetrisMain {
  public static final String WINDOW_TITLE = "INF101 Tetris";

  /**
   * The main method.
   * 
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    // Create the model, view and controller
    TetrisBoard board = new TetrisBoard(20, 10);
    //create a new random tetromino factory
    TetrominoFactory factory = new RandomTetrominoFactory();
    //create a new tetris model with the board and the factory
    TetrisModel model = new TetrisModel(board, factory);
    //create a new tetris view with the model
    TetrisView tetrisView = new TetrisView(model);
    //create a new tetris controller with the model and the view
    TetrisController controller = new TetrisController(model, tetrisView);


    // The JFrame is the "root" application window.
    // We here set som properties of the main window, 
    // and tell it to display our tetrisView
    JFrame frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(tetrisView);
    frame.addKeyListener(controller);
    
    // Call these methods to actually display the window
    frame.pack();
    frame.setVisible(true);
  }
}

