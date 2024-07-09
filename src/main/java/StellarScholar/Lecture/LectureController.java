package StellarScholar.Lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stellar_scholar/lecture")
public class LectureController {
    @Autowired
    private LectureService lectureService;

    @GetMapping("/{id}")
    public List<LectureModel> getAllLecturesByCourseId(@PathVariable(value = "id") int courseId) {
        return  lectureService.getLecturesByCourseId(courseId);
    }

}
