import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *This is the frame that serves as the scroll for the message to roll across
 */
public class ScrollFrame extends JFrame
{
    private static final int FRAME_W = 350;
    private static final int FRAME_H = 62;  //needs to be accomodate size of
                                            //text box in ScrollComponent
    private ScrollComponent scene;
    
    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            scene.moveLetters(-5); //negative, to go left to right
        }
    }
    
    
    public ScrollFrame()  
    {
        scene = new ScrollComponent();
        add(scene);
        
        setSize(FRAME_W, FRAME_H);
        
        ActionListener listener = new TimerListener();
        
        final int DELAY = 50;
        Timer t = new Timer(DELAY, listener);
        t.start();
    }
}
