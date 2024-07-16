package StellarScholar.Guardian;

import StellarScholar.Exception.ResourceNotFoundException;
import StellarScholar.Student.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardianService {
    @Autowired
    private GuardianRepository guardianRepository;

    public List<GuardianModel> getAllGuardian()
    {
        return guardianRepository.findAll();
    }

    public GuardianModel getGuardianById(int id) throws ResourceNotFoundException
    {
          GuardianModel guardian = guardianRepository.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("Guardian not found for this id :: " + id));;
          return guardian;
    }

    public GuardianModel CreateGuardian(GuardianModel guardian)
    {
        return guardianRepository.save(guardian);
    }

}
