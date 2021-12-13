package kodlamaio.hrmsProject.core.adapters.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Candidate;

public interface MernisCheckService {
	Result checkIfRealPerson(Candidate candidate);
}
