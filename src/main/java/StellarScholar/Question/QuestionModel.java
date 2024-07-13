package StellarScholar.Question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "question_written_model")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(QuestionKey.class)
public class QuestionModel {
    @Id
    @Column(name = "exam_id", nullable = false)
    private Long examId;

    @Id
    @Column(name = "question_number")
    private Integer questionNum;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(nullable = false)
    private int marks;
}
