package no.uib.inf101.tetris.controller;
import no.uib.inf101.tetris.view.TetrisView;

import java.awt.event.KeyListener;

import javax.swing.Timer;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import no.uib.inf101.tetris.model.tetromino.GameState;

import no.uib.inf101.tetris.midi.TetrisSong;

/**
*The TetrisController class is responsible for controlling the interaction between the user input and the
*ControllableTetrisModel and TetrisView.
*/

public class TetrisController implements KeyListener {
    private final TetrisView view;
    private final ControllableTetrisModel model;
    public Timer timer;
    private TetrisSong song = new TetrisSong();

    /**
     * Constructs a TetrisController object with a ControllableTetrisModel and TetrisView.
     *
     * @param model The ControllableTetrisModel.
     * @param view The TetrisView.
     */
    //vill at den skal opptadere seg hver gang en knapp blir trykket på
    public TetrisController(ControllableTetrisModel model, TetrisView view) {
        this.model = model;
        this.view = view;
        this.timer = new Timer(model.getTickIntervalMilliseconds(), this::clockTick);
        
        view.addKeyListener(this);
        view.setFocusable(true);
        // timer.start();
        song.run();
        if (model.getGameState() == GameState.ACTIVE_GAME) {
            song.run();
            timer.start();
        }
    }

    /**
     * Called when the timer clock ticks. Calls clockTick() in the model and repaint() in the view.
     *
     * @param e The ActionEvent object that represents the timer clock tick.
     */
    public void clockTick(ActionEvent e) {
        this.model.clockTick();
        this.view.repaint();
    }
   
    public void Delay(){
        timer.setDelay(model.getTickIntervalMilliseconds());
        timer.setInitialDelay(model.getTickIntervalMilliseconds());
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT 
        && model.getGameState() == GameState.ACTIVE_GAME)  {
            this.model.moveTetromino(0, -1);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT 
        && model.getGameState() == GameState.ACTIVE_GAME) {
            this.model.moveTetromino(0, 1);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN 
        && model.getGameState() == GameState.ACTIVE_GAME) {
            this.model.moveTetromino(1, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP 
        && model.getGameState() == GameState.ACTIVE_GAME) {
            this.model.rotateTetromino();
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if(model.getGameState() == GameState.ACTIVE_GAME) {
                model.pauseGame();
                timer.stop();
            }
            else if(model.getGameState() == GameState.PAUSED) {
                model.startGame();
                timer.start();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(model.getGameState() == GameState.WELCOME) {
                model.Welcome();
                timer.start();
            }
        
        }
           
        if (e.getKeyCode() == KeyEvent.VK_SPACE
        && model.getGameState() == GameState.ACTIVE_GAME) {
            this.model.score();
            this.model.dropTetromino();
            this.timer.restart();

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