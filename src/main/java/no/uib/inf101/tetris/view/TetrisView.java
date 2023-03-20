package no.uib.inf101.tetris.view;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.tetromino.GameState;

import no.uib.inf101.tetris.TetrisBoard;
import no.uib.inf101.tetris.TetrisModel;

import java.awt.geom.Rectangle2D;
/** 
* The TetrisView class is a JPanel that displays the current state of a Tetris game.
* It extends the JPanel class and implements the drawing of the game components.
*/

public class TetrisView extends JPanel { 
    //sets the width and height of the panel
    int width = 502;
    int height = 1000;

    //sets the color theme and the model
    private final ColorTheme colorT;
    private final TetrisModel model;


    /**
     * Creates a new TetrisView with the given TetrisModel.
     *
     * @param model The TetrisModel to display.
     */
    public TetrisView(TetrisModel model) {
        this.model = model;

        // sets the color theme to the default color theme
        colorT = new DefaultColorTheme();

        // sets the background color to the background color of the color theme
        colorT.getBackgroundColor();
        
        //sets the panel to be focusable and sets the preferred size
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(width, height));
        
    }

    /**
     * Draws the given cells onto the given graphics context using the given converter and color theme.
     *
     * @param g2d    The graphics context to draw onto.
     * @param cells  The cells to draw.
     * @param cellPos The converter to use to convert cell positions to pixel positions.
     * @param colors The color theme to use to draw the cells.
     */

    public static void drawcells(Graphics2D g2d, Iterable<GridCell<Character>> cells, 
    CellPositionToPixelConverter cellPos, ColorTheme colors) {
        for (GridCell<Character> cell : cells) {
            Rectangle2D rect = cellPos.getBoundsForCell(cell.pos());
            g2d.setColor(colors.getCellColor(cell.value()));
            g2d.fill(rect);
        }
    }

    /**
     * Draws the current state of the Tetris game onto the given graphics context.
     *
     * @param g2d The graphics context to draw onto.
     */
    public void drawGame(Graphics2D g2d) {
        // calculate the dimensions of the game board
        double margin = 2;
        double x = margin * 5;
        double y = margin * 5;
        double width = this.getWidth() - 10 * margin;
        double height = this.getHeight() - 10 * margin;
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);

        // draw the game board
        g2d.setColor(colorT.getFrameColor());
        g2d.fill(rect);
        
        // create a converter to convert cell positions to pixel positions
        CellPositionToPixelConverter cellPos = new CellPositionToPixelConverter(rect, model.getDimension(), margin);
        
        // draw the cells on the game board and the position of the current tetromino
        drawcells(g2d, model.getTilesOnBoard(), cellPos, colorT);
        drawcells(g2d, model.getTilesOnTetromino(), cellPos, colorT);

        //draw the score and the level
        drawPoints(g2d);

        // if the game is GameOver, draw the GameOver text 
        if (model.getGameState() == GameState.GAME_OVER) {
            drawGameOver(g2d);
        }
        // if the game is paused, draw the pause text
        if (model.getGameState() == GameState.PAUSED) {
            drawPause(g2d);
        }
        if (model.getGameState() == GameState.WELCOME) {
            drawWelcome(g2d);
        }
    }   

    /**
     * Draws the game over message when the game ends.
     * @param g2d The Graphics2D object used to draw the game over message.
     */
    public void drawGameOver(Graphics2D g2d) {
        g2d.setColor(colorT.getFrameColor());
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.WHITE);
        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 50));
        g2d.drawString("Game Over", 110 , height / 3 );
        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 20 ));
        g2d.drawString("Your Score was: " + model.score(), 140, height / 2 + 50);

        g2d.drawString("You reached level: " + model.levels(), 140, height / 2 + 100);
        }

    /**
     * Draws the pause message when the game is paused.
     * @param g2d The Graphics2D object used to draw the pause message.
     */
    public void drawPause(Graphics2D g2d) {
        g2d.setColor(colorT.getFrameColor());
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        g2d.setColor(Color.WHITE);
        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 50));
        g2d.drawString("Pause", 120 , height / 2 );

        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 20 ));
        g2d.drawString("Score: " + model.score(), 120 , height / 2 + 50);

        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 20 ));
        g2d.drawString("Press P to continue", 120 , height / 2 + 100);
    }

    /**
     * Draws the welcome message when the game starts.
     * @param g2d The Graphics2D object used to draw the welcome message.
     */
    public void drawWelcome(Graphics2D g2d) {
        g2d.setColor(colorT.getFrameColor());
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        g2d.setColor(Color.WHITE);
        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 42));
        g2d.drawString("Welcome to Clean Tetris", 9 , height / 3 );

        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 20 ));
        g2d.drawString("Press 'Enter' to start", 120 , height / 2 - 50);
        g2d.drawString("Press 'P' to pause", 120 , height / 2 );


    }

    /**
     * Draws the score and the level.
     * @param g2d The Graphics2D object used to draw the score and the level.
     */
    public void drawPoints(Graphics2D g2d) {
        g2d.setColor(new Color(255,134,138));
        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 20));
        g2d.drawString("Score: " + model.score(),  20,30);
        g2d.drawString("Level: " + model.levels(),  20,60);
    }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGame(g2);
  }

}



