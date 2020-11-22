/*
 * Jeremiah Stowe
 * Spring 2013
 */
package tools;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

/**
 * Concrete class that creates Rectangles and adds them to the drawn item list.
 * @author Jeremiah Stowe
 * @version Spring 2013
 */
public class RectangleTool extends AbstractTool
{

  /**
   * Creates the rectangle shape to be added.
   * @param the_event MouseEvent passed to the set shape method
   */
  public void makeShape(final MouseEvent the_event)
  {
    if (super.getPoint().getX() == 0 && super.getPoint().getY() == 0)
    {
      super.setPoint(the_event.getX(), the_event.getY());
     
    }
    
    if (the_event.getID() == MouseEvent.MOUSE_PRESSED)
    {
      super.setPoint(the_event.getX(), the_event.getY());
    }
    
    if (the_event.getID() == MouseEvent.MOUSE_RELEASED)
    {
      super.addItem(super.getShape());
      super.setPoint(0, 0);
    }
    
    if (the_event.getID() == MouseEvent.MOUSE_DRAGGED)
    {
      super.setShape(directionCorrection(the_event));
  
    }
  }
  
  /**
   * Helper method to check for an object being drawn in a direction that
   * will produce negative values from the starting point.
   * @param the_event The mouse event.
   * @return Returns the rectangle object.
   */
  private Rectangle2D.Double directionCorrection(final MouseEvent the_event)
  {
    Rectangle2D.Double g = null;
    final double x = super.getPoint().getX() - the_event.getX();
    final double y = super.getPoint().getY() - the_event.getY();
    
    if (x < 0 && y > 0)
    {
      g = new Rectangle2D.Double(super.getPoint().getX(), 
                                 the_event.getY(), Math.abs(x), Math.abs(y));
    }
    else if (x > 0 && y < 0)
    {
      g = new Rectangle2D.Double(the_event.getX(), 
                                 super.getPoint().getY(), Math.abs(x), Math.abs(y));
    }
    else if (x < 0 && y < 0)
    {
      g = new Rectangle2D.Double(super.getPoint().getX(), 
                                 super.getPoint().getY(), Math.abs(x), Math.abs(y));
    }
    else 
    {
      g = new Rectangle2D.Double(the_event.getX(), 
                                 the_event.getY(), Math.abs(x), Math.abs(y));
    }
    
    return g;
  }
}
