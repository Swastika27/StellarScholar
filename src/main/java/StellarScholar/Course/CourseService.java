package StellarScholar.Course;

import StellarScholar.Exception.ResourceNotFoundException;
import StellarScholar.Student.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseModel getCourseById (Long courseId)
            throws ResourceNotFoundException {
        CourseModel course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));
        return course;
    }

    public CourseModel createCourse(CourseModel course) {
        return courseRepository.save(course);
    }
}
