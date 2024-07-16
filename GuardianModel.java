package StellarScholar.Guardian;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guardian")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuardianModel {
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


    public GuardianModel(String firstName, String lastName,String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }
}
