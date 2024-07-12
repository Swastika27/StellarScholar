package StellarScholar.Exam;

import StellarScholar.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    public List<ExamModel> getAllExams() {
        return examRepository.findAll();
    }

    public List<ExamModel> getExamByCourseId(Long courseId) {
        Sort sort = Sort.by(Sort.Order.desc("date"),
                Sort.Order.desc("time"));

        return examRepository.getByCourseId(courseId, sort);
    }

    public ExamModel getExamById(Long examId) {
        ExamModel examModel = examRepository.findById(examId).orElseThrow(() -> {
            new ResourceNotFoundException("Exam not found for id " + examId);
            return null;
        });
        return examModel;
    }

    public ExamModel saveExam(ExamModel exam) {
        return examRepository.save(exam);
    }
}
