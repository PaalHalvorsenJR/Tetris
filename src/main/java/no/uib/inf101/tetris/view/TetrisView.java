package no.uib.inf101.tetris.view;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;

import no.uib.inf101.grid.GridCell;
import java.awt.geom.Rectangle2D;

public class TetrisView extends JPanel { 
    private final ColorTheme colorT;
    private final ViewableTetrisModel model;

   
// opprett en instansvariabel av typen ColorTheme
    public TetrisView(ViewableTetrisModel model) {
        this.model = model;
        colorT = new DefaultColorTheme();
        colorT.getBackgroundColor();
        
        this.setFocusable(true);
        
        this.setPreferredSize(new Dimension(300, 600));
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
        double x = margin;
        double y = margin;
        double width = this.getWidth() - 2 * margin;
        double height = this.getHeight() - 2 * margin;
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);

        g2d.setColor(colorT.getFrameColor());
        g2d.fill(rect);
        
        CellPositionToPixelConverter cellPos = new CellPositionToPixelConverter(rect, model.getDimension(), margin);
        
        drawcells(g2d, model.getTilesOnBoard(), cellPos, colorT);
        drawcells(g2d, model.getTilesOnTetromino(), cellPos, colorT);
    }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGame(g2);
  }

}



