package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result checkCandidate(JobExperience jobExperience);
	Result checkWorkplaceName(JobExperience jobExperience);
	Result checkPosition(JobExperience jobExperience);
	Result checkEntryYear(JobExperience jobExperience);
	Result checkAll(JobExperience jobExperience);
	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAllByOrderByQuitYearDesc();
	Result update(JobExperience jobExperience);
}
