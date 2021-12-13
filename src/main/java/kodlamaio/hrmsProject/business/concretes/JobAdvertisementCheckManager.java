package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementCheckService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CityDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.WorkStyleDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementCheckManager implements JobAdvertisementCheckService{
	
	private JobTitleDao jobTitleDao;
	private CityDao cityDao;
	private WorkStyleDao workStyleDao;
	private WorkTimeDao workTimeDao;
	
	@Autowired
	public JobAdvertisementCheckManager(JobTitleDao jobTitleDao, CityDao cityDao, WorkStyleDao workStyleDao,
			WorkTimeDao workTimeDao) {
		super();
		this.jobTitleDao = jobTitleDao;
		this.cityDao = cityDao;
		this.workStyleDao = workStyleDao;
		this.workTimeDao = workTimeDao;
	}
	
	@Override
	public Result checkJobTitle(JobAdvertisement jobAdvertisement) {
		if(this.jobTitleDao.getById(jobAdvertisement.getJobTitle().getId()) == null) {
			return new ErrorResult("This job title id is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkDescription(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getDescription().isEmpty()) { 
			return new ErrorResult("Description can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkCity(JobAdvertisement jobAdvertisement) {
		if(this.cityDao.getById(jobAdvertisement.getCity().getId()) == null) {
			return new ErrorResult("This city is not valid");
		}
		return new SuccessResult();
	}
	
	@Override
	public Result checkSalary(JobAdvertisement jobAdvertisement) {
		if(! jobAdvertisement.getMinSalary().isEmpty() && ! jobAdvertisement.getMaxSalary().isEmpty()) {
			if(Integer.parseInt(jobAdvertisement.getMinSalary()) >= Integer.parseInt(jobAdvertisement.getMaxSalary())) {
				return new ErrorResult("Min salary should be less than max salary");
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkOpenPositionNumber(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getOpenPositionNumber() <= 0 ) {
			return new ErrorResult("Open position number should be positive");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkDeadline(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getDeadlineDate() == null) {
			return new ErrorResult("Application deadline can not be empty");
		}
		else if(jobAdvertisement.getDeadlineDate().before(jobAdvertisement.getReleaseDate())) {
			return new ErrorResult("Application deadline can not be before than the release date");
		}
		return new SuccessResult();
	}
	
	@Override
	public Result checkWorkStlye(JobAdvertisement jobAdvertisement) {
		if(this.workStyleDao.getById(jobAdvertisement.getWorkStyle().getId()) == null) {
			return new ErrorResult("This work style is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkWorkTime(JobAdvertisement jobAdvertisement) {
		if(this.workTimeDao.getById(jobAdvertisement.getWorkTime().getId()) == null) {
			return new ErrorResult("This work time is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkAll(JobAdvertisement jobAdvertisement) {
		if(! checkJobTitle(jobAdvertisement).isSuccess()) {
			return new ErrorResult(this.checkJobTitle(jobAdvertisement).getMessage());
		}
		else if(! (checkDescription(jobAdvertisement).isSuccess())) {
			return new ErrorResult(checkDescription(jobAdvertisement).getMessage());
		}
		else if(! (checkCity(jobAdvertisement).isSuccess())) {
			return new ErrorResult(checkCity(jobAdvertisement).getMessage());
		}
		else if(! (checkSalary(jobAdvertisement).isSuccess())) {
			return new ErrorResult(checkSalary(jobAdvertisement).getMessage());
		}
		else if(! (checkOpenPositionNumber(jobAdvertisement).isSuccess())) {
			return new ErrorResult(checkOpenPositionNumber(jobAdvertisement).getMessage());
		}
		else if(! (checkDeadline(jobAdvertisement).isSuccess())) {
			return new ErrorResult(checkDeadline(jobAdvertisement).getMessage());
		}
		else if(! (checkWorkStlye(jobAdvertisement).isSuccess())) {
			return new ErrorResult(checkWorkStlye(jobAdvertisement).getMessage());
		}
		else if(! (checkWorkTime(jobAdvertisement).isSuccess())) {
			return new ErrorResult(checkWorkTime(jobAdvertisement).getMessage());
		}
		return new SuccessResult();
	}

}
