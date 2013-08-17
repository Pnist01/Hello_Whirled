import javax.swing.JFrame;

/**
 * This program moves a message box like a scroll.
 */
public class ScrollViewer
{
    
    public static void main(String[] args)
    {
        JFrame frame = new ScrollFrame();
        frame.setTitle("Hello Whirled");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
    
