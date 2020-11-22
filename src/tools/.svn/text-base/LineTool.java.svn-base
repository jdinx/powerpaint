/*
 * Jeremiah Stowe
 * Spring 2013
 */
package tools;

import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
/**
 * Line tool that implements lines from the abstract tool.
 * @author Jeremiah Stowe
 * @version Spring 2013
 *
 */
public class LineTool extends AbstractTool
{

  
  /**
   * Makes a line based on the mouse event being passed.
   * @param the_event The mouse event that is generating the shape.
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
      final GeneralPath g = new GeneralPath();
      g.moveTo(super.getPoint().getX(), super.getPoint().getY());
      g.lineTo(the_event.getX(), the_event.getY());
      super.setShape(g);
    }
    

  }
}
