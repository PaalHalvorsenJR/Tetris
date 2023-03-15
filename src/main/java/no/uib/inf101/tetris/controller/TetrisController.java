package no.uib.inf101.tetris.controller;
import no.uib.inf101.tetris.view.TetrisView;

import java.awt.event.KeyListener;

import javax.swing.Timer;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import no.uib.inf101.tetris.model.tetromino.GameState;

import no.uib.inf101.tetris.midi.TetrisSong;


public class TetrisController implements KeyListener {
    private final TetrisView view;
    private final ControllableTetrisModel model;
    private final Timer timer;
    private TetrisSong song = new TetrisSong();


    public TetrisController(ControllableTetrisModel model, TetrisView view) {
        this.model = model;
        this.view = view;

        this.timer = new Timer(model.getTickIntervalMilliseconds(), this::clockTick);
    
        view.addKeyListener(this);
        view.setFocusable(true);
        timer.start();
        if (model.getGameState() == GameState.ACTIVE_GAME) {
            song.run();
        }
    }

    public void clockTick(ActionEvent e) {
        if (model.getGameState() == GameState.ACTIVE_GAME) {
            model.moveTetromino(1, 0);
            view.repaint();
        }
    }

    private void Delay(){
        timer.setDelay(model.getTickIntervalMilliseconds());
        timer.setInitialDelay(model.getTickIntervalMilliseconds());
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