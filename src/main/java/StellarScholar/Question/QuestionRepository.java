package StellarScholar.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, QuestionKey> {
    @Query("select q from QuestionModel q where q.examId = ?1")
    List<QuestionModel> findByExamId(Long examId);
}
