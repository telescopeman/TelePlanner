import javax.swing.JLabel;
import javax.swing.Box;

public class HeaderPanel extends LinePanel{
    public HeaderPanel(String text) {
        super(HEADER_FONT);
        add(new JLabel(text+":"));
        setAlignmentX(Box.RIGHT_ALIGNMENT);
    }
}
