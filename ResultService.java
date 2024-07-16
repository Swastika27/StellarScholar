package StellarScholar.Result;

import StellarScholar.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public List<ResultModel> getAllResult()
    {
        return resultRepository.findAll();
    }

    public List<ResultModel> getResultByStudentId(int id) throws ResourceNotFoundException
    {
        List<ResultModel> result = (List<ResultModel>) resultRepository.findByStudentId(id);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Result not found for this student: " + id);
        }
        return result;
    }
    public ResultModel CreateResult(ResultModel result)
    {
       return resultRepository.save(result);
    }
}
