package no.uib.inf101.tetris.view;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;

import no.uib.inf101.grid.GridCell;
import java.awt.geom.Rectangle2D;

public class TetrisView extends JPanel { 
    private ColorTheme ColorT;
    private ViewableTetrisModel model;

   
// opprett en instansvariabel av typen ColorTheme
    public TetrisView(ViewableTetrisModel model) {
        this.model = model;
        this.ColorT = new DefaultColorTheme();

        this.setFocusable(true);
        this.setPreferredSize(new Dimension(300, 600));
    }

    public static void drawcells(Graphics2D g2d, Iterable<GridCell<Character>> cells, CellPositionToPixelConverter cellPos, ColorTheme colors) {
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
        ColorTheme colorsT = new DefaultColorTheme();
        g2d.setColor(colorsT.getFrameColor());
        g2d.fill(new Rectangle2D.Double(x, y, width, height));
        CellPositionToPixelConverter cellPos = new CellPositionToPixelConverter(new Rectangle2D.Double(x, y, width, height), model.getDimension(), margin);
        drawcells(g2d, model.getTitlesOnBoard(), cellPos, colorsT);
    }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGame(g2);
  }

}



