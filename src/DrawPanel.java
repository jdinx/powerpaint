/*
 * Jeremiah Stowe
 * Spring 2013
 */


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D.Double;

import javax.swing.JPanel;

import tools.AbstractTool;
import tools.EllipseTool;
import tools.LineTool;
import tools.PanelItem;
import tools.PencilTool;
import tools.RectangleTool;

/**
 * Drawing Panel that everything is drawn to.
 * @author Jeremiah Stowe
 * @version Spring 2013
 *
 */
@SuppressWarnings("serial")
public class DrawPanel extends JPanel
{
  /**
   * Grid spacing constant.
   */
  private static final int GRID_SIZE = 10;
  /**
   * Static constant for panel height.
   */
  private static final int DEFAULT_HEIGHT = 300;
  /**
   * Static constant for panel width.
   */
  private static final int DEFAULT_WIDTH = 400;
  /**
   * 
   */
  private AbstractTool my_current_tool;
  /**
   * 
   */
  private float my_thickness;
  /**
   * Color of the object being drawn.
   */
  private Color my_color;
  /**
   * Boolean to track if the grid is on or not.
   */
  private boolean my_grid_is_on;
  /**
   * Draw panel no arg constructor to set size and background.
   */
  public DrawPanel()
  {
    super();
    setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    setBackground(Color.WHITE);
    addMouseListener(new ClickListener());
    addMouseMotionListener(new ClickListener());
    my_current_tool = new PencilTool();
    my_thickness = 1f;
    my_grid_is_on = false;
    
  }

  /**
   * Paints the drawn paths.
   * 
   * @param the_graphics The graphics context to use for painting.
   */
  public void paintComponent(final Graphics the_graphics)
  {
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);

    
    for (PanelItem s : my_current_tool.getItems())
    {
      g2d.setColor(s.getColor());
      g2d.setStroke(new BasicStroke(s.getStroke()));
      g2d.draw(s.getShape());
    }
    
    //Draws the current object in the tool before it is put on the stack
    if (my_current_tool.getShape() != null)
    {
      g2d.setColor(my_color);
      g2d.setStroke(new BasicStroke(my_thickness));
      g2d.draw(my_current_tool.getShape());
    }  
     
    if (my_grid_is_on)
    {
      int i = 0;
      while (i <= getWidth())
      {
        g2d.setStroke(new BasicStroke(1f));
        g2d.setColor(Color.gray);
        g2d.draw(new Line2D.Double(0, i, getWidth(), i));
        g2d.draw(new Line2D.Double(i, 0, i, getHeight()));
        i = i + GRID_SIZE;
      }
    }
    
    g2d.setColor(my_color);
    g2d.setStroke(new BasicStroke(my_thickness));
  }
  
  /**
   * Setter for the current color to draw with.
   * @param the_color The new color to change to.
   */
  public void setColor(final Color the_color)
  {
    my_color = the_color;
  }
  
  /**
   * The thickness of the object that is being drawn.
   * @param the_thickness The new thickness for the objects drawn.
   */
  public void setThickness(final float the_thickness)
  {
    my_thickness = the_thickness;
  }
  
  /**
   * 
   * @param the_tool The tool being changed to
   */
  public void setLine(final LineTool the_tool)
  {
    
    my_current_tool = the_tool;
  }
  /**
   * 
   * @param the_tool The tool being changed to
   */
  public void setRectangle(final RectangleTool the_tool)
  {
    
    my_current_tool = the_tool;
  }
  /**
   * 
   * @param the_tool The tool being changed to
   */
  public void setEllipse(final EllipseTool the_tool)
  {
    my_current_tool = the_tool;
  }
  /**
   * 
   * @param the_tool The tool being changed to
   */
  public void setPencil(final PencilTool the_tool)
  {
    my_current_tool = the_tool; 
  }
  /**
   * 
   */
  public void clearItems()
  {
    my_current_tool.clear();
    repaint();
  }
  
  /**
   * Clears the current shape from the tool.
   */
  public void clearShape()
  {
    my_current_tool.setShape(null);
    repaint();
  }

  /**
   * Toggles to draw the grid when the option is selected.
   * @param the_selected True if check box for grid is checked.
   */
  public void setGrid(final boolean the_selected)
  {
    my_grid_is_on = the_selected;
    repaint();
  }  
  
  /**
   * 
   * @author Jeremiah
   * @version 11/24/2012
   */
  private class ClickListener extends MouseAdapter
  {
      /**
       * @param the_event The event for the mouse clicked awt 
       */
    public void mouseClicked(final MouseEvent the_event)
    {
      my_current_tool.setColor(my_color);
      my_current_tool.setStroke(my_thickness);
      my_current_tool.makeShape(the_event);
      repaint();
    }
     /**
      * @param the_event The event for the mouse released awt 
      */
    public void mouseReleased(final MouseEvent the_event)
    {
      my_current_tool.setColor(my_color);
      my_current_tool.setStroke(my_thickness);
      my_current_tool.makeShape(the_event);
      repaint();
    }
    
      /**
       * @param the_event The event for the mouse dragged awt 
       */
    public void mouseDragged(final MouseEvent the_event)
    {
      my_current_tool.setColor(my_color);
      my_current_tool.setStroke(my_thickness);
      my_current_tool.makeShape(the_event);
      repaint();
    }
      
  }

}
  


