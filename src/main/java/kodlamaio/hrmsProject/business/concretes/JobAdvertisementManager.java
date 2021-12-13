package kodlamaio.hrmsProject.business.concretes;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementCheckService;
import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementCheckService jobAdvertisementCheckService;
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementCheckService jobAdvertisementCheckService,
			JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementCheckService = jobAdvertisementCheckService;
		this.jobAdvertisementDao = jobAdvertisementDao;
	}



	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if(! (this.jobAdvertisementCheckService.checkAll(jobAdvertisement).isSuccess())) {
			Date date = new Date();
			jobAdvertisement.setReleaseDate(date);
			return new ErrorResult(this.jobAdvertisementCheckService.checkAll(jobAdvertisement).getMessage());
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added successfully");
	}



	@Override
	public Result makePassive(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.getById(jobAdvertisement.getId()).setActive(false);
		this.jobAdvertisementDao.save(this.jobAdvertisementDao.getById(jobAdvertisement.getId()));
		return new SuccessResult("Job advertisement is passive now");
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(true));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveOrderByDeadlineDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveOrderByDeadlineDate(true));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsOfAnEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_IdAndIsActive(employerId));
	}

	@Override
	public DataResult<JobAdvertisement> getById(int jobAdvertisementId) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(jobAdvertisementId));
	}
}
