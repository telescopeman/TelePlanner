import java.time.LocalDate;
import java.util.ArrayList;

public class Utility {

    public static ArrayList<Task> getTestSchedule()
    {
        final ArrayList<Task> mySchedule = new ArrayList<>();
        Task essay = new Task("Essay", LocalDate.of(2021,9,4));
        mySchedule.add(new Task("Worksheet", LocalDate.of(2021,9,1),true));
        mySchedule.add(essay);
        mySchedule.add(new Task("Test", LocalDate.of(2021,9,5)));
        mySchedule.add(new DependentTask("Essay Revisions",
                LocalDate.of(2021,9,13),essay));
        mySchedule.add(new Task("Another Test", LocalDate.of(2021,10,5)));
        return mySchedule;
    }
}
