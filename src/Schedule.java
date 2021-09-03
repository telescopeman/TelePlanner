import java.util.ArrayList;

public class Schedule {

    private ArrayList<Task> tasks;

    public void addTask(Task task)
    {
        tasks.add(task);
    }

    public Task getTask(int index)
    {
        return tasks.get(index);
    }


}
