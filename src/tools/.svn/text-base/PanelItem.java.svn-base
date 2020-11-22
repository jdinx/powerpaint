package tools;
import java.awt.Color;
import java.awt.Shape;

/**
 * Contains the information required for the graphics 2D
 * object to draw each object as it is created and then placed onto
 * the stack of panel items.
 * @author Jeremiah Stowe
 * @version Spring 2013
 *
 */
public class PanelItem
{
  /**
   * Color of the graphics item.
   */
  private final Color my_color;
  /**
   * Shape type of the graphics item.
   */
  private  Shape my_shape;
  /**
   * Thickness of the graphics item being drawn.
   */
  private final float my_stroke;
  
  /**
   * Constructor to create panel item with the given param criteria.
   * @param the_color The color of the graphic item.
   * @param the_stroke The thickness of the graphic item.
   * @param the_shape The shape of the graphic item.
   */
  public PanelItem(final Color the_color, final float the_stroke, final Shape the_shape)
  {
    my_color = the_color;
    my_stroke = the_stroke;
    my_shape = the_shape;
  }
  
  /**
   * Getter for the color of the graphic item.
   * @return Returns the color of the current item.
   */
  public Color getColor()
  {
    return my_color;
  }
  
  /**
   * Getter for the thickness of the stroke of the current graphics item.
   * @return Returns the thickness of the stroke.
   */
  public float getStroke()
  {
    return my_stroke;
  }
  /**
   * Returns the shape of the current panel item.
   * @return Returns the shape of the current panel item.
   */
  public Shape getShape()
  {
    return my_shape;
  }
  
  /**
   * Sets the shape type of the current graphics item.
   * @param the_shape The shape that is being set for the current grahpics item.
   */
  public void setShape(final Shape the_shape)
  {
    my_shape = the_shape;
  }
}
