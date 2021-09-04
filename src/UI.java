import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.util.ArrayList;

public class UI extends JFrame {
    public static final int WIDTH = 800;
    private static final int HEIGHT = 1200;
    public final JPanel innerPanel = new JPanel();
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
        innerPanel.removeAll();
        innerPanel.revalidate();
        ArrayList<TaskPanel> panels = new ArrayList<>();
        for (Task task : currentSchedule)
        {
            panels.add(new TaskPanel(task,this));
        }

        new TaskScanner(this,"Done:") {
            @Override
            protected boolean validate(Task task) {
                return task.isComplete();
            }
        }.batchAdd(panels);
        new TaskScanner(this,"Assignments:") {
            @Override
            protected boolean validate(Task task) {
                return true;
            }
        }.batchAdd(panels);

        innerPanel.revalidate();
    }








}
