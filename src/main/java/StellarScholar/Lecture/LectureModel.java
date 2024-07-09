package StellarScholar.Lecture;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Lecture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "lecture_num", nullable = false)
    private Integer lectureNumber;
}





