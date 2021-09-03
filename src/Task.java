import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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


    public String formatDueDate()
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
