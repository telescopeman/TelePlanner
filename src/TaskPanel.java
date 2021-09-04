import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class TaskPanel extends LinePanel {
    private boolean already_placed = false;
    private final Task task;

    public Task getTask()
    {
        return task;
    }

    public void setPlaced()
    {
        already_placed = true;
    }

    public boolean isAlreadyPlaced()
    {
        return already_placed;
    }

    public TaskPanel(Task task,UI ui)
    {
        super(STANDARD_FONT);
        this.task = task;
        setLayout(new GridLayout(1,3));
        JLabel label1 = new JLabel(task.getTitle());
        JLabel label2 = new JLabel("due " + task.formatDueDate());
        boolean possible = task.isPossible();
        add(label1);

        JButton button = new JButton();
        button.addActionListener(e -> {
            task.markAsComplete();
            ui.refresh();
        });
        int ind = task.getIndex();

        button.setPreferredSize(new Dimension(getHeight(),getHeight()));
        if (ind > -1)
        {
            button.setLayout(new BorderLayout());
            JLabel textLabel = new JLabel(Alphabet.UPPERCASE.toChar(ind), button.CENTER);
            button.add(textLabel);
        }
        button.setEnabled(possible);
        add(button);
        add(label2);

    }
}
