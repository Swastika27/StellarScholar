package StellarScholar.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionKey implements Serializable {
    private Long examId;
    private Integer questionNum;
}
