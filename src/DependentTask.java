import java.time.LocalDate;

public class DependentTask extends Task{
    public DependentTask(String name, LocalDate dueDate, Task myDependency) {
        super(name,dueDate);
        setPossible(false);
        myDependency.setDependent(this);
    }
}
