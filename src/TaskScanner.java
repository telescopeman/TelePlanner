import java.util.ArrayList;

public abstract class TaskScanner {
    private final UI ui;
    private final String headerName;

    public TaskScanner(UI ui, String headerName)
    {
        this.ui = ui;
        this.headerName = headerName;
    }

    protected abstract boolean validate(Task task);

    public void batchAdd(ArrayList<TaskPanel> panels)
    {
        ui.innerPanel.add(new SimpleLine(headerName,SimpleLine.HEADER_FONT));

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
            ui.innerPanel.add(SimpleLine.BLANK_LINE);
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
            ui.innerPanel.add(p);
            p.setPlaced();
            return true;
        }
        return false;
    }
}
