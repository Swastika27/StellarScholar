package StellarScholar.Course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(name = "class",
            nullable = false
    )
    private Integer clss;

    @Column(name = "subject_id",
            nullable = false
    )
    private Integer subjectId;

    @Column(nullable = false)
    private Integer hardness;

    @Column(name = "start_date",
            nullable = false
    )
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "total_lecture",
            nullable = false
    )
    private Integer totalLecture;
}
