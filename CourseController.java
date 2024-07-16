package StellarScholar.Course;

import StellarScholar.Exception.ResourceNotFoundException;
import StellarScholar.Lecture.LectureService;
import StellarScholar.Lecture.WeeklySchedule;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stellar_scholar/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private LectureService lectureService;

    @GetMapping
    public List<CourseModel> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModel> getCourseById (@PathVariable(value = "id") Long courseId) throws ResourceNotFoundException {
        CourseModel course =  courseService.getCourseById(courseId);

        return ResponseEntity.ok().body(course);
    }

    @PostMapping
    public ResponseEntity<CourseModel> createSchedules(@RequestBody CourseRequestDTO courseRequestDTO) {
        LocalDate startDateTime = courseRequestDTO.getStartDate();
        int count = courseRequestDTO.getTotalLecture();
        List<WeeklySchedule> weeklySchedules = courseRequestDTO.getWeeklySchedules().stream()
                .map(dto -> new WeeklySchedule(
                        DayOfWeek.valueOf(dto.getDayOfWeek().toUpperCase()),
                        LocalTime.parse(dto.getTime())))
                .collect(Collectors.toList());

        CourseModel course =
                courseService.createCourse(
                        CourseModel.builder().
                                clss(courseRequestDTO.getClss())
                                .subjectId(courseRequestDTO.getSubjectId())
                                .startDate(courseRequestDTO.getStartDate())
                                .totalLecture(courseRequestDTO.getTotalLecture())
                                .build());

        lectureService.createLectures(course.getId(), startDateTime.atStartOfDay(), count, weeklySchedules);
        return ResponseEntity.ok().body(course);
    }
}
