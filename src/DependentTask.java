import java.time.LocalDate;

public class DependentTask extends Task{
    private Task dependency;
    public DependentTask(String name, LocalDate dueDate, Task dependency) {
        super(name,dueDate);
        this.dependency = dependency;
    }

    private void setDependency(Task dependency)
    {
        this.dependency = dependency;
        dependency.setDependent();
    }

    public Task getDependency()
    {
        return dependency;
    }
}
