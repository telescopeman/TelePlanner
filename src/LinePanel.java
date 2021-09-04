import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;

public class LinePanel extends JPanel {
    private static final double LINE_SPACING = 1.5;
    private static final String FONT_NAME = "Consolas";
    protected static final Font STANDARD_FONT = new Font(FONT_NAME,Font.PLAIN,20),
            HEADER_FONT = new Font(FONT_NAME,Font.BOLD,30);

    public LinePanel(Font font)
    {
        setFont(font);
        int height = (int) ((double)getFont().getSize() * LINE_SPACING);
        Dimension myDim = new Dimension(UI.WIDTH,height);
        setSize(myDim);
        setMaximumSize(myDim);

    }

    public Component add(Component c)
    {
        c.setFont(getFont());
        return super.add(c);
    }
}
