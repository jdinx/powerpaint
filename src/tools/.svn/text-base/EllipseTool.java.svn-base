/*
 * Jeremiah Stowe
 * Spring 2013
 */
package tools;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
/**
 * Ellipse circle tool concrete class that implements abstract tool.
 * @author Jeremiah Stowe
 * @version Spring 2013
 *
 */
public class EllipseTool extends AbstractTool
{

  /**
   * Method to create the ellipse based on the mouse clicked events.
   * @param the_event The mouse event that is generating the ellipse shape.
   */
  public void makeShape(final MouseEvent the_event)
  {
    if (super.getPoint().getX() == 0 && super.getPoint().getY() == 0)
    {
      super.setPoint(the_event.getX(), the_event.getY());
     
    }
    
    if (the_event.getID() == MouseEvent.MOUSE_RELEASED)
    {
      super.addItem(super.getShape());
      super.setPoint(0, 0);
    }
    
    if (the_event.getID() == MouseEvent.MOUSE_PRESSED)
    {
      super.setPoint(the_event.getX(), the_event.getY());
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
   * @return Returns the ellipse object.
   */
  private Ellipse2D.Double directionCorrection(final MouseEvent the_event)
  {
    Ellipse2D.Double g = null;
    final double x = super.getPoint().getX() - the_event.getX();
    final double y = super.getPoint().getY() - the_event.getY();
    
    if (x < 0 && y > 0)
    {
      g = new Ellipse2D.Double(super.getPoint().getX(), 
                               the_event.getY(), Math.abs(x), Math.abs(y));
    }
    else if (x > 0 && y < 0)
    {
      g = new Ellipse2D.Double(the_event.getX(), super.getPoint().getY(),
                               Math.abs(x), Math.abs(y));
    }
    else if (x < 0 && y < 0)
    {
      g = new Ellipse2D.Double(super.getPoint().getX(), 
                               super.getPoint().getY(), Math.abs(x), Math.abs(y));
    }
    else 
    {
      g = new Ellipse2D.Double(the_event.getX(), the_event.getY(), Math.abs(x), Math.abs(y));
    }
    return g;
  }
}
