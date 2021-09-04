import java.time.LocalDate;

public class DependentTask extends Task{
    private static int global_index = 0;

    public DependentTask(String name, LocalDate dueDate, Task myDependency) {
        super(name,dueDate);
        if (!myDependency.isComplete()) {
            setPossible(false);
        }
        myIndex = global_index;
        global_index++;
        myDependency.setDependent(this);
    }
}
