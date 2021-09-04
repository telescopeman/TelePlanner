import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;

public class SimpleLine extends LinePanel {

    public static final SimpleLine BLANK_LINE = new SimpleLine("(None)",STANDARD_FONT);

    public SimpleLine(String str, Font font) {
        super(font);
        add(new JLabel(str));
        setAlignmentX(Box.RIGHT_ALIGNMENT);
    }
}
