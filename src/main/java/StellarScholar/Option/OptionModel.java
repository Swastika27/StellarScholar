package StellarScholar.Option;

import StellarScholar.Question.QuestionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "option")
@IdClass(QuestionKey.class)
public class OptionModel {
    @Id
    @Column(name = "exam_id", nullable = false)
    private Long examId;

    @Id
    @Column(name = "question_number")
    private Integer questionNum;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Option rightAnswer;
}
