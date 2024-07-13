package StellarScholar.Question;

import StellarScholar.Option.OptionModel;
import StellarScholar.Option.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    public List<QuestionModel> getByExamId(Long examId) {
        return questionRepository.findByExamId(examId);
    }

    public QuestionModel saveQuestion(QuestionModel q) {
        return questionRepository.save(q);
    }

    public QuestionModel saveQuestion(QuestionModel q, OptionModel o) {
        optionRepository.save(o);
        return questionRepository.save(q);
    }
}
