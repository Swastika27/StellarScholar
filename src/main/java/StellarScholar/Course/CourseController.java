package StellarScholar.Course;

import StellarScholar.Exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stellar_scholar/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<CourseModel> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModel> getCourseById (@PathVariable(value = "id") Long courseId) throws ResourceNotFoundException {
        return (ResponseEntity<CourseModel>) courseService.getCourseById(courseId);
    }

    @PostMapping("")
    public CourseModel createCourse(@Valid @RequestBody CourseModel courseModel) {
        return courseService.createCourse(courseModel);
    }
}
