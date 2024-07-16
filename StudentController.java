package StellarScholar.Student;

import StellarScholar.Data;
import StellarScholar.Exception.ResourceNotFoundException;
import StellarScholar.Result.ResultModel;
import StellarScholar.Result.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/stellar_scholar")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ResultService resultService;

    @GetMapping("/student")
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable(value = "id") int studentId) throws ResourceNotFoundException {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/student")
    public StudentModel createStudent(@Valid @RequestBody StudentModel student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/student/{id}/result")
    public ResponseEntity<List<ResultModel>> getResultBystudentId(@PathVariable(value = "id") int studentId) throws ResourceNotFoundException {
        List<ResultModel> result = resultService.getResultByStudentId(studentId);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/api/data")
    public String receiveData(@RequestBody Data data) {
        System.out.println("IN FUNCTION");
        System.out.println(data.getUser() + "  " + data.getPassword());

        return "Data received successfully";

    }
}
