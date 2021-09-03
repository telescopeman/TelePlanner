import java.time.LocalDate;

public class Task {
    private LocalDate dueDate;
    private boolean hasDependent = false,
            possible = true,
            complete = false;

    public Task(String title, LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public void finish()
    {
        complete = true;
    }

    public boolean isPossible()
    {
        return possible;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setDependent()
    {
        hasDependent = true;
    }

    public boolean hasDependent()
    {
        return hasDependent;
    }

    public void setDueDate(LocalDate newDate)
    {
        dueDate = newDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
