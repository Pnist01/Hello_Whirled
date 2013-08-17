import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JComponent;


/**
 *  Shows a scrolling message
 */
public class ScrollComponent extends JComponent
{
    private Color newColor;
    private static final int starting_X = 350;  //starting point, at far right of frame
    private static final int starting_Y = 2;  // not 0, to scootch it away from tippy top
    
    private static final int BOX_W = 0;  // box of arbitrary size to attach (drawString) letters
    private static final int BOX_H =  0;  // (can add box to scroll, if I want to later)
       
    private Rectangle box;
    
    Random generator = new Random();
    
    
    
    public ScrollComponent()
    {
        box = new Rectangle(starting_X, starting_Y, BOX_W, BOX_H);

    }

    /**
     * the letters are attached to a 2D box
     * (I know, I could have made this differently)
     */
    public void paintComponent(Graphics g)
    {
        Font f = new Font("Dialog", Font.BOLD, 25); //added
        g.setFont(f);   //added
        Graphics2D g2 = (Graphics2D) g;
        int x = (int)box.getX(); 
        int y = (int)box.getY() + 20; // + 20 for spacing
        g2.drawString("Hello, Whirled", x, y);
    }
    
    /**
     * Moves the words by amount passed in.
     *@param x the amount to be moved sideways
     *@param end the end of the scroll (frame)
     */
    public void moveLetters(int x)
    {
        box.translate(x, 0);
        repaint();
        if (box.getX() < -200)  // -200 a magic number beyond left part of frame for reset to right
        {
            
            newColor = new Color(generator.nextInt(256), 
                                 generator.nextInt(256),
                                 generator.nextInt(256));
                                 
            setForeground(newColor);

            //resets the scrolling text to the left of the frame (200 is a magic number)
            box.translate(starting_X + 200, 0);
        }
    }
}
