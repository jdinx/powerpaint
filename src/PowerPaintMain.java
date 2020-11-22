/*
 * Jeremiah Stowe
 * Spring 2013
 */

/**
 * Main class for Power Paint program to call the GUI.
 * @author Jeremiah Stowe
 * @version Spring 2013
 *
 */
public final class PowerPaintMain
{
  /**
   * Prevent outside instantiation.
   */
  private PowerPaintMain()
  {
    
  }
  
  /**
   * Main entry point for the program.
   * @param the_args System arguments for the programs.
   */
  public static void main(final String[] the_args)
  {
    final PowerPaintGUI gui = new PowerPaintGUI();
    gui.start();
  }

  
}
