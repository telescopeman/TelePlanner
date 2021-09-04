import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.util.ArrayList;

public class UI extends JFrame {
    public static final int WIDTH = 800;
    private static final int HEIGHT = 1200;
    private final JPanel INNER_PANEL = new JPanel();
    private ArrayList<Task> currentSchedule;

    public static void main(String [] args)
    {
        new UI();
    }

    public UI()
    {
        setTitle("TelePlanner");
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        JScrollPane outer = new JScrollPane(INNER_PANEL);
        outer.getVerticalScrollBar().setUnitIncrement(16);
        INNER_PANEL.setLayout(new BoxLayout(INNER_PANEL, BoxLayout.Y_AXIS));
        add(outer);

        final ArrayList<Task> mySchedule = Utility.getTestSchedule();
        load(mySchedule);

    }
    private void load(ArrayList<Task> schedule)
    {
        currentSchedule = schedule;
        refresh();
    }

    public void refresh()
    {
        INNER_PANEL.removeAll();
        INNER_PANEL.revalidate();
        ArrayList<TaskPanel> panels = new ArrayList<>();
        for (Task task : currentSchedule)
        {
            panels.add(new TaskPanel(task,this));
        }

        new TaskScanner(INNER_PANEL,"Done:") {
            @Override
            protected boolean validate(Task task) {
                return task.isComplete(); }
        }.batchAdd(panels);
        new TaskScanner(INNER_PANEL,"Assignments:") {
            @Override
            protected boolean validate(Task task) {
                return true;
            }
        }.batchAdd(panels);

        INNER_PANEL.revalidate();
    }








}
