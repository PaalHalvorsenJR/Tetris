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


public class TetrisView extends JPanel { 
    int width = 500;
    int height = 1000;

    private final ColorTheme colorT;
    private final TetrisModel model;
    private  TetrisBoard board;



   
// opprett en instansvariabel av typen ColorTheme
    public TetrisView(TetrisModel model) {
        this.model = model;

        colorT = new DefaultColorTheme();
        colorT.getBackgroundColor();
        
        
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(width, height));
        
    }

    public static void drawcells(Graphics2D g2d, Iterable<GridCell<Character>> cells, 
    CellPositionToPixelConverter cellPos, ColorTheme colors) {
        for (GridCell<Character> cell : cells) {
            Rectangle2D rect = cellPos.getBoundsForCell(cell.pos());
            g2d.setColor(colors.getCellColor(cell.value()));
            g2d.fill(rect);
        }
    }
    public void drawGame(Graphics2D g2d) {
        double margin = 2;
        double x = margin * 5;
        double y = margin * 5;
        double width = this.getWidth() - 10 * margin;
        double height = this.getHeight() - 10 * margin;
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);

        g2d.setColor(colorT.getFrameColor());
        g2d.fill(rect);
        
        CellPositionToPixelConverter cellPos = new CellPositionToPixelConverter(rect, model.getDimension(), margin);
        
        drawcells(g2d, model.getTilesOnBoard(), cellPos, colorT);
        drawcells(g2d, model.getTilesOnTetromino(), cellPos, colorT);

        // drawPoints(g2d);
        drawPoints(g2d);
        if (model.getGameState() == GameState.GAME_OVER) {
            drawGameOver(g2d);
            // drawPoints(g2d);
        }
    }

    public void drawGameOver(Graphics2D g2d) {
    
        g2d.setColor(colorT.getFrameColor());
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.WHITE);
        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 50));
        g2d.drawString("Game Over", 120 , height / 2 );

    }

    public void drawPoints(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 20));
        g2d.drawString("Score: " + model.score(),  20,30);
    }
    
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGame(g2);
  }

}



