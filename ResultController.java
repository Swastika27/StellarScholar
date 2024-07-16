package StellarScholar.Result;

import StellarScholar.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    @RequestMapping("/result")
    public List<ResultModel> getAllResult()
    {
        return resultService.getAllResult();
    }
    @RequestMapping("/result/{id}")
    public ResponseEntity<List<ResultModel>> getResultBystudentId(@PathVariable int id)
    {
        try {
            List <ResultModel> result = resultService.getResultByStudentId(id);
            return ResponseEntity.ok().body(result);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(method = RequestMethod.POST , value = "/result")
    public ResultModel CreateResult(ResultModel result)
    {
       return resultService.CreateResult(result);
    }
}
