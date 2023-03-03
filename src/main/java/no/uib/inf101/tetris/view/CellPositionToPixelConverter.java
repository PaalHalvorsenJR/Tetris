package no.uib.inf101.tetris.view;
import java.awt.geom.Rectangle2D;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;

public class CellPositionToPixelConverter {
  private double margin; 
  private GridDimension gd; 
  private Rectangle2D box; 

  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
    this.gd = gd;
    this.box = box;
    this.margin = margin;
  }

  public Rectangle2D getBoundsForCell(CellPosition pos) {
    double w = (box.getWidth() - margin - gd.cols() * margin) / gd.cols();
    double h = (box.getHeight() - margin - gd.rows() * margin) / gd.rows();
    double x = box.getX() + margin + pos.col() * (w + margin);
    double y = box.getY() + margin + pos.row() * (h + margin);
    return new Rectangle2D.Double(x, y, w, h);
  }
}

