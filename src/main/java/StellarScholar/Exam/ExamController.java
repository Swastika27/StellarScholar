package StellarScholar.Exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stellar_scholar/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @GetMapping
    public List<ExamModel> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/course/{id}")
    public List<ExamModel> getByCourseId(@PathVariable(name = "id") Long courseId) {
        return examService.getExamByCourseId(courseId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamModel> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(examService.getExamById(id));
    }

    @PostMapping
    public ExamModel saveExam(ExamModel examModel) {
        return examService.saveExam(examModel);
    }
}
