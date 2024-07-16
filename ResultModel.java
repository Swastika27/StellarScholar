package StellarScholar.Result;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "result")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(Composite.class)
public class ResultModel {

    @Id
    @Column(name = "examid"/*, nullable = false*/)
    private int examId;

    @Id
    @Column(name = "studentid"/*, nullable = false*/)
    private int studentId;

    @Column(name = "score")
    private double marks;

}
