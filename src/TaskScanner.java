import java.awt.Container;
import java.util.ArrayList;

public abstract class TaskScanner {
    private final Container INNER_PANEL;
    private final String HEADER_NAME;

    public TaskScanner(Container panel, String headerName)
    {
        this.INNER_PANEL = panel;
        this.HEADER_NAME = headerName;
    }

    protected abstract boolean validate(Task task);

    public void batchAdd(ArrayList<TaskPanel> panels)
    {
        INNER_PANEL.add(new SimpleLine(HEADER_NAME,SimpleLine.HEADER_FONT));
        boolean empty = true;
        for (TaskPanel taskPanel : panels)
        {
            if (validate(taskPanel.getTask()))
            {
                if (addIfFirstTime(taskPanel))
                {
                    empty = false;
                }
            }
        }
        if (empty)
        {
            INNER_PANEL.add(SimpleLine.BLANK_LINE);
        }
    }

    /**
     * Adds if it has not been added already.
     * @return If anything was added.
     */
    private boolean addIfFirstTime(TaskPanel p)
    {
        if (!p.isAlreadyPlaced())
        {
            INNER_PANEL.add(p);
            p.setPlaced();
            return true;
        }
        return false;
    }
}
