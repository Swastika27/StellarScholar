package StellarScholar.Guardian;

import StellarScholar.Result.ResultModel;
import StellarScholar.Student.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardianRepository extends JpaRepository<GuardianModel, Integer> {
    @Query(value = "SELECT * FROM guardian WHERE email = :email AND password = :password " , nativeQuery = true)
    GuardianModel guardianLogin(@Param("email") String email, @Param("password") String passsword);
}
