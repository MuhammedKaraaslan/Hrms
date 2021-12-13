package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Candidate;
import kodlamaio.hrmsProject.entities.dtos.CandidateCvDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int candidateId);
	Result add(Candidate candidate, String passwordAgain);
	Result verifyEmail(int id);
	DataResult<List<CandidateCvDto>> getCandidateWithCvDetails(int candidateId);
}
