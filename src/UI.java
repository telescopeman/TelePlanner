import javax.swing.JFrame;
import java.awt.Dimension;
import java.time.LocalDate;


public class UI extends JFrame {

    private static final Dimension dim = new Dimension(400,1200);
    private Schedule mySchedule;

    public static void main(String [] args)
    {
        new UI();
    }

    public UI()
    {
        setTitle("TelePlanner");
        setVisible(true);
        setSize(dim);
        mySchedule = new Schedule();

    }
}
