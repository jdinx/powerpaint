/*
 * Jeremiah Stowe
 * Spring 2013
 */
package tools;

import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

/**
 * 
 * @author Jeremiah Stowe
 * @version Spring 2013
 */
public class PencilTool extends AbstractTool
{




/**
 * Creates the line as it is dragged, resetting the initial point on being released.
 * @param the_event The mouse event being passed to this method.
 */
  public void makeShape(final MouseEvent the_event)
  {
    if (the_event.getID() == MouseEvent.MOUSE_RELEASED)
    {
      super.setPoint(0, 0);
    }
    
    if (the_event.getID() == MouseEvent.MOUSE_DRAGGED)
    {
      if (super.getPoint().getX() == 0 && super.getPoint().getY() == 0)
      {
        super.setPoint(the_event.getX(), the_event.getY());
     
      }
    
      final GeneralPath g = new GeneralPath();
      g.moveTo(super.getPoint().getX(), super.getPoint().getY());
      g.lineTo(the_event.getX(), the_event.getY());
      super.setPoint(the_event.getX(), the_event.getY());
      super.addItem(g);
    }
  }

    
    

}
