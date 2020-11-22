/*
 * Jeremiah Stowe
 * Spring 2013
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import tools.EllipseTool;
import tools.LineTool;
import tools.PanelItem;
import tools.PencilTool;
import tools.RectangleTool;

/**
 * Class that creates all the user interface equipment
 * including toolbars, menus and draw panel for the program.
 * @author Jeremiah Stowe
 * @version Spring 2013
 *
 */
public class PowerPaintGUI
{
  /**
   * Thicknesses to be included.
   */
  private static final int[] THICKNESSES = {1, 2, 4};
 /**
  *Main container for the program. 
  */
  private final JFrame my_frame;
  /**
   * Composition to attach the drawing panel to the frame.
   */
  private final DrawPanel my_board;
  /**
   * Pencil Tool action.
   */
  private final Action my_pencil;
  /**
   * Action for the line.
   */
  private final Action my_line;
  /**
   * Action for the rectangle.
   */
  private final Action my_rectangle;
  /**
   * Action for the ellipse.
   */
  private final Action my_ellipse;
  /**
   * Action for color.
   */
  private final Action my_color;
  /**
   * Field to access the color button.
   */
  private JButton my_color_button;
  /**
   * Field to access the color menu item.
   */
  private JMenuItem my_color_item;
  /**
   * Pencil tool to add shapes with.
   */
  private final PencilTool my_pencil_tool;
  /**
   * Line tool to add lines with.
   */
  private final LineTool my_line_tool;
  /**
   * Rectangle tool to add rectangles with.
   */
  private final RectangleTool my_rectangle_tool;
  /**
   * Ellipse tool to add ellipse shapes with.
   */
  private final EllipseTool my_ellipse_tool;
  /**
   * Stack of items that are drawn on the drawing panel.
   */
  private final Stack<PanelItem> my_items;

  
  /**
   * Basic no argument constructor for the frame.
   */
  PowerPaintGUI()
  {
    my_frame = new JFrame("TCSS 305 PowerPaint, Spring 2013");
    my_board = new DrawPanel();
    my_items = new Stack<PanelItem>();
    my_pencil = new Pencil();
    my_line = new Line();
    my_rectangle = new Rectangle();
    my_ellipse = new Ellipse();
    my_color = new ColorButton();
    my_pencil_tool = new PencilTool();
    my_line_tool = new LineTool();
    my_rectangle_tool = new RectangleTool();
    my_ellipse_tool = new EllipseTool();
    setItems();
  }
  
  /**
   * Entry point for the program to be called from the
   * main method in the PowerPaintMain class.
   */
  public void start()
  {
    
    my_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    my_frame.add(my_board);
    my_frame.setJMenuBar(makeMenuBar());
    my_frame.add(makeToolBar(), BorderLayout.SOUTH);
    my_frame.setLocationByPlatform(true);
    my_frame.pack();
    my_frame.setVisible(true);
  }

  /**
   * Makes the toolbar with actions attached for each
   * tool type and color selector.
   * @return Returns the JToolBar with the items attached.
   */
  private JToolBar makeToolBar()
  {
    final JToolBar tool_bar = new JToolBar();
    final ButtonGroup group = new ButtonGroup();
    my_color_button = new JButton(my_color);
    my_color_button.setBackground(Color.BLACK);
    my_color_button.setForeground(Color.WHITE);
    final JButton pencil = new JButton(my_pencil);
    final JButton line = new JButton(my_line);
    final JButton rectangle = new JButton(my_rectangle);
    final JButton ellipse = new JButton(my_ellipse);
    pencil.setSelected(true);
    group.add(pencil);
    group.add(line);
    group.add(rectangle);
    group.add(ellipse);
    tool_bar.add(my_color_button);
    tool_bar.add(pencil);
    tool_bar.add(line);
    tool_bar.add(rectangle);
    tool_bar.add(ellipse);
    return tool_bar;
  }
  
  /**
   * Makes the menu for the program with the options
   * and dropped down menus for control and information.
   * @return Returns the menu bar to be placed in frame.
   */
  private JMenuBar makeMenuBar()
  {
    final JMenuBar j = new JMenuBar();
    j.add(makeFileMenu());
    j.add(makeOptionsMenu());
    j.add(makeToolsMenu());
    j.add(makeHelpMenu());
    j.setVisible(true);
    return j;
  }
  
  /**
   * Makes the File Menu options to attached to the 
   * Menu Bar.
   * @return Returns the File menu with it's menu items.
   */
  private JMenu makeFileMenu()
  {
    final JMenu file = new JMenu("File");
    file.setMnemonic(KeyEvent.VK_F);
    final JMenuItem clear = new JMenuItem("Clear", KeyEvent.VK_C);
    clear.addActionListener(new ActionListener() 
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_board.clearItems();
      }
    });
    file.add(clear);
    file.addSeparator();
 
    final JMenuItem quit = new JMenuItem("Exit", KeyEvent.VK_X);
    quit.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_frame.dispose();
      }
    });
    file.add(quit);
    return file;
  }
  
  /**
   * Makes the option menu items with it's sub menu items.
   * @return Returns the option menu.
   */
  private JMenu makeOptionsMenu()
  {
    final JMenu options = new JMenu("Options");
    options.setMnemonic(KeyEvent.VK_O);
    final JMenuItem grid = new JCheckBoxMenuItem("Grid");
    grid.setMnemonic(KeyEvent.VK_G);
    grid.addActionListener(new ActionListener() 
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        my_board.setGrid(grid.isSelected());
      }
    });
    final JMenu thickness = new JMenu("Thickness");
    thickness.setMnemonic(KeyEvent.VK_T);
    options.add(grid);
    options.add(thickness);
    
    final ButtonGroup group_thickness = new ButtonGroup();
    
    

    for (final Integer s : THICKNESSES)
    {
      final JMenuItem a = new JRadioButtonMenuItem(s.toString());
      a.setMnemonic(KeyEvent.VK_1 + s - 1);
      if (s == 1)
      {
        a.setSelected(true);
      }
      
      group_thickness.add(a);
      thickness.add(a);
      a.addActionListener(new ActionListener() 
      {
        public void actionPerformed(final ActionEvent the_event)
        {
          my_board.setThickness((float) s);
        }
      });
    }

    final JMenuItem undo = new JMenuItem("Undo", KeyEvent.VK_U);
    undo.addActionListener(new ActionListener() 
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        if (my_items.size() > 0)
        {
          my_items.pop();
        }
        my_board.clearShape();
        my_board.repaint();
      }
    });
    undo.setAccelerator(KeyStroke.getKeyStroke('Z', KeyEvent.CTRL_MASK));
    options.add(undo);
    return options;
  }
  
  /**
   * Makes the Tool Menu with it's sub items.
   * @return Returns the tool menu.
   */
  private JMenu makeToolsMenu()
  {

    final JMenu tools = new JMenu("Tools"); 
    tools.setMnemonic(KeyEvent.VK_T);
    my_color_item = new JMenuItem(my_color);
    my_color_item.setMnemonic(KeyEvent.VK_C);
    my_color_item.setBackground(Color.BLACK);
    my_color_item.setForeground(Color.WHITE);
    tools.add(my_color_item);
    tools.addSeparator();
    final ButtonGroup group = new ButtonGroup();
    
    final JMenuItem pencil = new JRadioButtonMenuItem(my_pencil);
    pencil.setMnemonic(KeyEvent.VK_P);
    final JMenuItem line = new JRadioButtonMenuItem(my_line);
    line.setMnemonic(KeyEvent.VK_L);
    final JMenuItem rectangle = new JRadioButtonMenuItem(my_rectangle);
    rectangle.setMnemonic(KeyEvent.VK_R);
    final JMenuItem ellipse = new JRadioButtonMenuItem(my_ellipse);
    ellipse.setMnemonic(KeyEvent.VK_E);
    pencil.setSelected(true);
    my_board.setPencil(my_pencil_tool);
    group.add(pencil);
    group.add(line);
    group.add(rectangle);
    group.add(ellipse);
    tools.add(pencil);
    tools.add(line);
    tools.add(rectangle);
    tools.add(ellipse);
    return tools;
  }
  
  /**
   * Makes the help menu with the about option item.
   * @return Returns the help menu.
   */
  private JMenu makeHelpMenu()
  {
    final JMenu help = new JMenu("Help"); 
    help.setMnemonic(KeyEvent.VK_H);
    final JMenuItem about = new JMenuItem("About...");
    about.setMnemonic(KeyEvent.VK_A);
    
    about.addActionListener(new ActionListener() 
    {
      public void actionPerformed(final ActionEvent the_event)
      {
        JOptionPane.showMessageDialog(my_frame, "TCSS 305 PowerPaint");
      }
    });
    
    help.add(about);
    return help;
  }

  /**
   * Sets the item stack to be the same for all the tools so that the 
   * shapes that are drawn are added all to one spot to be drawn.
   */
  private final void setItems()
  {
    my_pencil_tool.setItems(my_items);
    my_line_tool.setItems(my_items);
    my_rectangle_tool.setItems(my_items);
    my_ellipse_tool.setItems(my_items);
  }
  

  /**
   * 
   * @author Jeremiah
   *
   */
  @SuppressWarnings("serial")
  private class Pencil extends AbstractAction
  {
    /**
     * 
     */
    Pencil()
    {
     super("Pencil", new ImageIcon("pencil_bw.gif")); 
    }
    /**
     * @param the_event The event triggered when Pencil item is selected.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      my_pencil.putValue(SELECTED_KEY, true);
      my_board.setPencil(my_pencil_tool);
    }
  }
  
  /**
   * 
   * @author Jeremiah Stowe
   * @version Spring 2013
   */
  @SuppressWarnings("serial")
  private class Line extends AbstractAction
  {
    /**
     * 
     */
    Line()
    {
     super("Line", new ImageIcon("line_bw.gif"));
    }
    /**
     * @param the_event The event triggered when Line item is selected.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      my_line.putValue(SELECTED_KEY, true);
      my_board.setLine(my_line_tool);
    }
  }
  /**
   * 
   * @author Jeremiah
   *
   */
  @SuppressWarnings("serial")
  private class Rectangle extends AbstractAction
  {
    /**
     * 
     */
    Rectangle()
    {
     super("Rectangle", new ImageIcon("rectangle_bw.gif")); 
    }
    /**
     * @param the_event The event triggered when Rectangle item is selected.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      my_rectangle.putValue(SELECTED_KEY, true);
      my_board.setRectangle(my_rectangle_tool);
    }
  }
  /**
   * 
   * @author Jeremiah
   *
   */
  @SuppressWarnings("serial")
  private class Ellipse extends AbstractAction
  {
    /**
     * 
     */
    Ellipse()
    {
     super("Ellipse", new ImageIcon("ellipse_bw.gif")); 
    }
    /**
     * @param the_event The event triggered when Ellipse item is selected.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      my_ellipse.putValue(SELECTED_KEY, true);
      my_board.setEllipse(my_ellipse_tool);
    }
  }
  /**
   * 
   * @author Jeremiah Stowe
   * @version Spring 2013
   *
   */
  @SuppressWarnings("serial")
  private class ColorButton extends AbstractAction
  {
    /**
     * 
     */
    ColorButton()
    {
     super("Color..."); 
    }
    /**
     * @param the_event The event triggered when Color item is selected.
     */
    public void actionPerformed(final ActionEvent the_event)
    {
      final Color new_color = new JColorChooser().showDialog(my_frame, "Color", Color.BLACK);
      if (new_color != null)
      {
        my_board.setColor(new_color);
        my_color_button.setBackground(new_color);
        my_color_item.setBackground(new_color);
      }
    }
  }
}
