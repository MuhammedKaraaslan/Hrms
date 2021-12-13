package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

public interface CoverLetterService {
	Result checkCandidate(CoverLetter coverLetter);
	Result checkDetails(CoverLetter coverLetter);
	Result checkAll(CoverLetter coverLetter);
	Result add(CoverLetter coverLetter);
	Result update(CoverLetter coverLetter);
}
