import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;

public class TaskPanel extends JPanel {
    private static final double LINE_SPACING = 1.5;
    private final JLabel label1, label2;
    private final JButton button = new JButton();
    private static final Font STANDARD_FONT = new Font("Consolas",Font.PLAIN,20);

    public TaskPanel(Task task)
    {
        setLayout(new GridLayout(1,3));
        setFont(STANDARD_FONT);
        int height = (int) ((double)getFont().getSize() * LINE_SPACING);
        System.out.print(height);
        Dimension myDim = new Dimension(UI.WIDTH,height);
        setSize(myDim);
        setMaximumSize(myDim);


        label1 = new JLabel(task.getTitle());
        label2 = new JLabel("due " + task.formatDueDate());
        boolean possible = task.isPossible();
        add(label1);
        add(button);
        button.setEnabled(possible);
        add(label2);
    }


    public Component add(Component c)
    {
        c.setFont(getFont());
        return super.add(c);
    }
}
