package no.uib.inf101.tetris.controller;
import no.uib.inf101.tetris.view.TetrisView;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TetrisController implements KeyListener {
    private final TetrisView view;
    private final ControllableTetrisModel model;

    
    
    public TetrisController(ControllableTetrisModel model, TetrisView view) {
        this.model = model;
        this.view = view;
        view.addKeyListener(this);
        view.setFocusable(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            model.moveTetromino(0, -1);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            model.moveTetromino(0, 1);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.moveTetromino(1, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.rotateTetromino();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.dropTetromino();
        }
        view.repaint();
    }   

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        // TODO Auto-generated method stub

    }

}