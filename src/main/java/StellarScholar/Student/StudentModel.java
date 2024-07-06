package StellarScholar.Student;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "first_name",
        nullable = false
    )
    private String firstName;

    @Column(name = "last_name",
        nullable = false
    )
    private String lastName;

    @Column(name = "email",
            nullable = false
    )
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "class", nullable = false)
    private int clss;

    public StudentModel(String firstName, String lastName, String password, int clss) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.clss = clss;
    }
}
