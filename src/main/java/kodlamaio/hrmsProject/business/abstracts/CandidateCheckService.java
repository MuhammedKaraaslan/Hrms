package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Candidate;

public interface CandidateCheckService {
	Result checkFirstName(Candidate candidate);
	Result checkLastName(Candidate candidate);
	Result checkUniqueIdentityNumber(Candidate candidate);
	Result checkMernis(Candidate candidate);
	Result checkBirthYear(Candidate candidate);
	Result checkEmailAdress(Candidate candidate);
	Result checkPassword(Candidate candidate, String passwordAgain);
	Result checkAll(Candidate candidate, String passwordAgain);
}
