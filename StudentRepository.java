package StellarScholar.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    @Query(value = "SELECT * FROM student WHERE guardianid = :guardianId", nativeQuery = true)
    List<StudentModel> ShowChildrenforGuardian(@Param("guardianId") int guardianId);
}
