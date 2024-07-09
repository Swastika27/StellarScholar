package StellarScholar.Lecture;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class WeeklySchedule {
    private DayOfWeek dayOfWeek;
    private LocalTime time;

    public WeeklySchedule(DayOfWeek dayOfWeek, LocalTime time) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}

