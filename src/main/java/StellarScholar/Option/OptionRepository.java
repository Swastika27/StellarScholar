package StellarScholar.Option;

import StellarScholar.Question.QuestionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<OptionModel, QuestionKey> {
}
