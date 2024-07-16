package StellarScholar.Guardian;

import StellarScholar.Data;
import StellarScholar.Exception.ResourceNotFoundException;
import StellarScholar.Result.ResultModel;
import StellarScholar.Result.ResultRepository;
import StellarScholar.Student.StudentModel;
import StellarScholar.Student.StudentRepository;
import StellarScholar.Student.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuardianController {
    @Autowired
    private GuardianService guardianService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    GuardianRepository guardianRepository;
    @RequestMapping("/guardian")
    public List<GuardianModel> getAllGuardian()
    {
        return guardianService.getAllGuardian();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/guardian")
    public GuardianModel createGuardian(@Valid @RequestBody GuardianModel guardian)
    {
       return guardianService.CreateGuardian(guardian);
    }
    @RequestMapping("/guardian/{id}")
    public ResponseEntity<GuardianModel> getGuardianById(@PathVariable int id)
    {
        try {
            GuardianModel guardian = guardianService.getGuardianById(id);
            return ResponseEntity.ok().body(guardian);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping("/guardian/{id}/children")
    public ResponseEntity<List<StudentModel>> ShowAllChildren (@PathVariable(value = "id") int guardianId) throws ResourceNotFoundException {
        List<StudentModel> student =  studentRepository.ShowChildrenforGuardian(guardianId);
        return ResponseEntity.ok().body(student);
    }
    @RequestMapping("/guardian/{id}/children/{childId}")
    public ResponseEntity<List<ResultModel>> ShowChildResult (@PathVariable(value = "childId") int studentId) throws ResourceNotFoundException {
        List<ResultModel> result =  resultRepository.findByStudentId(studentId);
        return ResponseEntity.ok().body(result);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/guardian/data")
    public GuardianModel receiveData(@RequestBody Data send_data) {
        System.out.println("IN FUNCTION");
        System.out.println(send_data);
        System.out.println(send_data.Guardian + "  " + send_data.password);
        String user = send_data.Guardian;
        String password = send_data.password;
        GuardianModel guardian = guardianRepository.guardianLogin(user,password);
        return guardian;

    }

}
