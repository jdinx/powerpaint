/*
 * Jeremiah Stowe
 * Spring 2013
 */
package tools;

import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Stack;

/**
 * Abstract tool that stores all of the required information
 * for each concrete tool type.
 * @author Jeremiah Stowe
 * @version Spring 2013
 *
 */
public abstract class AbstractTool
{
  /**
   * Shape variable for all the tools that will be drawing.
   */
  private Shape my_shape;
  /**
   * Point for updating and drawing shape locations.
   */
  private final Point2D my_point;
  /**
   * Stroke thickness for the object being drawn.
   */
  private float my_stroke;
  /**
   * Current color being drawn.
   */
  private Color my_color;
  /**
   *Item list for the tool to access and add objects to. 
   */
  private Stack<PanelItem> my_items;
  
  /**
   * Class constructor.
   */
  public AbstractTool()
  {
    my_shape = null;
    my_point = new Point2D.Double();
    my_items = new Stack<PanelItem>();
  }
  
  /**
   * Constructor to create a tool by passing the item list to be used.
   * @param the_items Stack of items drawn on panel.
   */
  public AbstractTool(final Stack<PanelItem> the_items)
  {
    my_shape = null;
    my_point = new Point2D.Double();
    my_items = the_items;
  }
  
  /**
   * Makes the current object depending on the tool selected.
   * @param the_event Passes event type from mouse to tool.
   */
  public abstract void makeShape(final MouseEvent the_event);

  /**
   * Setter for shape being drawn.
   * @param the_shape The new shape being made.
   */
  public void setShape(final Shape the_shape)
  {
    my_shape = the_shape;
  }
  
  /**
   * Getter to return the current shape in the tool.
   * @return Shape stored in the specific tool.
   */
  public Shape getShape()
  {
    return my_shape;
  }
  
  /**
   * Sets the starting point from where the object is being drawn.
   * @param the_x The X starting value.
   * @param the_y The Y starting value.
   */
  public void setPoint(final double the_x, final double the_y)
  {
    my_point.setLocation(the_x, the_y);
  }
  
  /**
   * Returns the starting point for the object.
   * @return Returns the starting point.
   */
  public Point2D getPoint()
  {
    return my_point;
  }
  
  /**
   * Setter for the stroke of the object being created.
   * @param the_stroke Stroke value being set.
   */
  public void setStroke(final float the_stroke)
  {
    my_stroke = the_stroke;
  }
  
  /**
   * Getter for the current stroke value.
   * @return Returns the stroke value.
   */
  public float getStroke()
  {
    return my_stroke;
  }
  
  /**
   * Setter for the color of object being drawn.
   * @param the_color The color to set to.
   */
  public void setColor(final Color the_color)
  {
    my_color = the_color;
  }
  
  /**
   * Getter for the color from the current tool.
   * @return Returns the color of the current tool.
   */
  public Color getColor()
  {
    return my_color;
  }
    
  /**
   * Setter to associate a stack of drawn items with current tool.
   * @param the_items Item stack to associate with the tool.
   */
  public void setItems(final Stack<PanelItem> the_items)
  {
    my_items = the_items;
  }
  
  /**
   * Push the current shape onto the stack of items to be drawn.
   * @param the_shape Shape being added to the stack.
   */
  public void addItem(final Shape the_shape)
  {
    my_items.push(new PanelItem(my_color, my_stroke, the_shape));
  }
  
  /**
   * Returns a defensive copy of the stack of items being drawn.
   * @return Returns the copy of the object stack being drawn.
   */
  public Stack<PanelItem> getItems()
  {
    return (Stack<PanelItem>) my_items.clone();
  }
  
  /**
   * Removes all the objects for the drawn item stack.
   */
  public void clear()
  {
    my_items.clear();
    my_shape = null;
  }
}
