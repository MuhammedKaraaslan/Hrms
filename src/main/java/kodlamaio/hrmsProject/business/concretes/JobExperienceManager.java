package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.JobExperienceService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private CandidateDao candidateDao;
	
	@Autowired	
	public JobExperienceManager(JobExperienceDao jobExperienceDao, CandidateDao candidateDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result checkCandidate(JobExperience jobExperience) {
		if(this.candidateDao.getById(jobExperience.getCandidate().getId()) == null) {
			return new ErrorResult("This candidate id is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkWorkplaceName(JobExperience jobExperience) {
		if(jobExperience.getWorkPlaceName().isEmpty()) {
			return new ErrorResult("Workplace name can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkPosition(JobExperience jobExperience) {
		if(jobExperience.getPosition().isEmpty()) {
			return new ErrorResult("Position can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkEntryYear(JobExperience jobExperience) {
		if(jobExperience.getEntryYear().isEmpty()) {
			return new ErrorResult("Entry year can not be empty");
		}
		else if(Integer.parseInt(jobExperience.getEntryYear()) > Integer.parseInt(jobExperience.getQuitYear())) {
			return new ErrorResult("Entry year should be bigger than quit year");
		}			
		return new SuccessResult();
	}


	@Override
	public Result checkAll(JobExperience jobExperience) {
		if(! checkCandidate(jobExperience).isSuccess()) {
			return new ErrorResult(checkCandidate(jobExperience).getMessage());
		}
		else if(! checkWorkplaceName(jobExperience).isSuccess()) {
			return new ErrorResult(checkWorkplaceName(jobExperience).getMessage());
		}
		else if(! checkPosition(jobExperience).isSuccess()) {
			return new ErrorResult(checkPosition(jobExperience).getMessage());
		}
		else if(! checkEntryYear(jobExperience).isSuccess()) {
			return new ErrorResult(checkEntryYear(jobExperience).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result add(JobExperience jobExperience) {
		if(! checkAll(jobExperience).isSuccess()) {
			return new ErrorResult(checkAll(jobExperience).getMessage());
		}
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobExperience>> getAllByOrderByQuitYearDesc() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllByOrderByQuitYearDesc());
	}

	@Override
	public Result update(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Job experience updated");
	}

}
