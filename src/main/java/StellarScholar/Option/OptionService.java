package StellarScholar.Option;

import StellarScholar.Question.QuestionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public Optional<OptionModel> getById(QuestionKey q) {
        return optionRepository.findById(q);
    }

    public OptionModel saveOption(OptionModel o) {
        return  optionRepository.save(o);
    }
}
