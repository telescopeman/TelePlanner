import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class TaskPanel extends LinePanel {

    private final JLabel label1, label2;
    private final JButton button = new JButton();

    public TaskPanel(Task task,UI ui)
    {
        super(STANDARD_FONT);
        setLayout(new GridLayout(1,3));
        label1 = new JLabel(task.getTitle());
        label2 = new JLabel("due " + task.formatDueDate());
        boolean possible = task.isPossible();
        add(label1);
        add(button);
        button.addActionListener(e -> {
            task.markAsComplete();

            ui.load();
        });
        int ind = task.getIndex();
        if (ind > -1)
        {
            button.setText(Alphabet.UPPERCASE.toChar(ind));
        }
        button.setEnabled(possible);
        add(label2);
    }
}
