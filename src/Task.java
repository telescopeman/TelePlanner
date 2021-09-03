import java.time.LocalDate;

public class Task {
    private LocalDate dueDate, doneDate;
    private String title;
    private DependentTask dependentTask = null;
    private boolean possible = true,
            complete = false;

    public Task(String title, LocalDate dueDate)
    {
        this.title = title;
        this.dueDate = dueDate;
    }

    public void setTitle(String t)
    {
        title = t;
    }

    public String getTitle() {
        return title;
    }

    public void setComplete()
    {
        if (!complete) {
            complete = true;
            doneDate = LocalDate.now();
            if (hasDependent())
            {
                dependentTask.setPossible(true);
            }
        }
    }

    public void setPossible(boolean possible)
    {
        this.possible = possible;
    }

    public boolean isPossible()
    {
        return possible;
    }

    public boolean isComplete() {
        return complete;
    }


    public void setDependent(DependentTask dependentTask)
    {
        this.dependentTask = dependentTask;
    }


    public boolean hasDependent()
    {
        return dependentTask != null;
    }

    public void setDueDate(LocalDate newDate)
    {
        dueDate = newDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
