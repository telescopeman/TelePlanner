import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Font;

public class HeaderPanel extends LinePanel{
    public HeaderPanel(String text) {
        super(Font.BOLD,30);
        add(new JLabel(text+":"));
        setAlignmentX(Box.RIGHT_ALIGNMENT);
    }
}
