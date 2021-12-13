package kodlamaio.hrmsProject.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.core.adapters.abstracts.MernisCheckService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.entities.concretes.Candidate;

@Service
public class FakeMernisAdapter implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(Candidate candidate) {
		return new SuccessResult();
	}

}
