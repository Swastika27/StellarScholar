package StellarScholar.Course;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CourseRequestDTO {
    private LocalDate startDate;
    private int totalLecture;
    private List<WeeklyScheduleDTO> weeklySchedules;
    private int clss;
    private int hardness;
    private int subjectId;

    @Data
    public static class WeeklyScheduleDTO {
        private String dayOfWeek;
        private String time;

    }
}

