package StellarScholar.Student;

import StellarScholar.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<StudentModel> getStudentById( Long studentId)
            throws ResourceNotFoundException {
        StudentModel student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        return ResponseEntity.ok().body(student);
    }

    public StudentModel createStudent(StudentModel student) {
        return studentRepository.save(student);
    }
}
