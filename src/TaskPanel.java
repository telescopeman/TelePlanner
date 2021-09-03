import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TaskPanel extends JPanel {
    private static final double LINE_SPACING = 1.5;
    private final JLabel label1, label2;
    private final JButton button = new JButton();

    public TaskPanel(Task task)
    {
        setLayout(new GridLayout(1,3));
        setFont(new Font("Consolas",Font.PLAIN,20));
        int height = (int) ((double)getFont().getSize() * LINE_SPACING);
        System.out.print(height);
        Dimension myDim = new Dimension(UI.WIDTH,height);
        setSize(myDim);
        setMaximumSize(myDim);


        label1 = new JLabel(task.getTitle());
        label2 = new JLabel("due " + formatDueDate(task.getDueDate()));
        boolean possible = task.isPossible();
        add(label1);
        add(button);
        button.setEnabled(possible);
        add(label2);
    }


    private static String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        return switch (i % 100) {
            case 11, 12, 13 -> "th";
            default -> suffixes[i % 10];
        };
    }

    private static String toSentenceCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }


    private static String formatDueDate(LocalDate dueDate)
    {
        long i = ChronoUnit.DAYS.between(LocalDate.now(),dueDate);
        System.out.println(i);
        if (i ==0)
        {
            return "today";
        }
        else if (i==1)
        {
            return "tomorrow";
        }
        else if (i < 7)
        {
            return toSentenceCase(dueDate.getDayOfWeek().toString());
        }
        else if (i < 14)
        {
            return "next " + toSentenceCase(dueDate.getDayOfWeek().toString());
        }
        else if (i < 365)
        {
            int day_of_month = dueDate.getDayOfMonth();
            return toSentenceCase(dueDate.getMonth().toString()) + " " +
                    day_of_month + ordinal(day_of_month);
        }
        else
        {
            return dueDate.toString();
        }
    }

    public Component add(Component c)
    {
        c.setFont(getFont());
        return super.add(c);
    }
}
