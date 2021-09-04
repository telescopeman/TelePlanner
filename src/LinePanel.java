import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;

public class LinePanel extends JPanel {
    private static final double LINE_SPACING = 1.5;


    public LinePanel(int style, int size)
    {

        int myStyle = (style & ~0x03) == 0 ? style : 0;
        setFont(new Font("Consolas",myStyle, size));
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
