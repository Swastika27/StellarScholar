package StellarScholar.Result;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


public class Composite implements Serializable {

    private int examId;
    private int studentId;

    // Default constructor
    public Composite() {}

    // Constructor with parameters
    public Composite(int keyPart1, int keyPart2) {
        this.examId = keyPart1;
        this.studentId = keyPart2;
    }

    // Getters and setters
    /*public Long getKeyPart1() {
        return examId;
    }

    public void setKeyPart1(int keyPart1) {
        this.examId = keyPart1;
    }

    public Long getKeyPart2() {
        return studentId;
    }

    public void setKeyPart2(Long keyPart2) {
        this.studentId = keyPart2;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite that = (Composite) o;
        return Objects.equals(examId, that.examId) &&
                Objects.equals(studentId, that.studentId);
    }
}

