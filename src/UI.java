import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.time.LocalDate;
import java.util.ArrayList;

public class UI extends JFrame {
    public static final int WIDTH = 800;
    private static final int HEIGHT = 1200;
    private final JPanel innerPanel = new JPanel();
    private ArrayList<Task> currentSchedule;

    public static void main(String [] args)
    {
        new UI();
    }

    public UI()
    {
        setTitle("TelePlanner");
        setVisible(true);
        setSize(WIDTH,HEIGHT);
        JScrollPane outer = new JScrollPane(innerPanel);
        outer.getVerticalScrollBar().setUnitIncrement(16);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        add(outer);

        Task essay = new Task("Essay", LocalDate.of(2021,9,4));

        final ArrayList<Task> mySchedule = new ArrayList<>();
        mySchedule.add(essay);
        mySchedule.add(new Task("Test", LocalDate.of(2021,9,5)));
        mySchedule.add(new DependentTask("Essay Revisions",
                LocalDate.of(2021,9,13),essay));
        mySchedule.add(new Task("Another Test", LocalDate.of(2021,10,5)));

        load(mySchedule);

    }
    private void load(ArrayList<Task> schedule)
    {
        currentSchedule = schedule;
        load();
    }

    public void load()
    {
        innerPanel.removeAll();
        innerPanel.revalidate();
        ArrayList<TaskPanel> panels = new ArrayList<>();
        for (Task task : currentSchedule)
        {
            panels.add(new TaskPanel(task,this));
        }

        innerPanel.add(new HeaderPanel("Assignments"));

        for (TaskPanel taskPanel : panels)
        {
            innerPanel.add(taskPanel);
        }
    }
}
