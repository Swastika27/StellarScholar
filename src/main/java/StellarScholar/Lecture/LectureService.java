package StellarScholar.Lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService {
    @Autowired
    private LectureRepository lectureRepository;

    private LocalDateTime getNextDate(LocalDateTime startDate, WeeklySchedule weeklySchedule) {
        LocalDateTime nextDate = startDate.with(weeklySchedule.getDayOfWeek()).with(weeklySchedule.getTime());
        if (nextDate.isBefore(startDate)) {
            nextDate = nextDate.plusWeeks(1);
        }
        return nextDate;
    }

    private List<LocalDateTime> calculateDates(LocalDateTime startDate, int count, List<WeeklySchedule> weeklySchedules) {
        List<LocalDateTime> dates = new ArrayList<>();
        LocalDateTime currentDate = startDate;

        while (dates.size() < count) {
            for (WeeklySchedule weeklySchedule : weeklySchedules) {
                if (dates.size() >= count) break;

                LocalDateTime nextDate = getNextDate(currentDate, weeklySchedule);
                if (nextDate.isAfter(startDate) || nextDate.isEqual(startDate)) {
                    dates.add(nextDate);
                }
            }
            currentDate = currentDate.plusWeeks(1);
        }

        return dates;
    }

    private void saveDates(long courseId, List<LocalDateTime> dates) {
        List<LectureModel> schedules = new ArrayList<>();
        for (LocalDateTime date : dates) {
            LectureModel schedule = new LectureModel();

            schedule.setCourseId(courseId);
            schedule.setLectureNumber(schedules.size() + 1);
            schedule.setDateTime(date);

            schedules.add(schedule);
        }
        lectureRepository.saveAll(schedules);
    }

    public void createLectures(long courseId, LocalDateTime startDate, int count, List<WeeklySchedule> weeklySchedules) {
        List<LocalDateTime> dates = calculateDates(startDate, count, weeklySchedules);
        saveDates(courseId, dates);
    }

    public List<LectureModel> getLecturesByCourseId(int courseId){

        return lectureRepository.findByCourseId(courseId);
    }
}
