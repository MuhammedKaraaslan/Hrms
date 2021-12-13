package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployerCheckService;
import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.core.utilities.abstracts.EmailVerificationService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.EmployerUpdate;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	private EmailVerificationService emailVerificationService;
	private EmployerUpdateDao employerUpdateDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService,
			EmailVerificationService emailVerificationService, EmployerUpdateDao employerUpdateDao) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
		this.emailVerificationService = emailVerificationService;
		this.employerUpdateDao = employerUpdateDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers  listed");
	}
	
	@Override
	public DataResult<Employer> getById(int id) {
		for (EmployerUpdate employerUpdate : this.employerUpdateDao.findAll()) {
			if(employerUpdate.getUserId() == id) {
				return new SuccessDataResult<Employer>(this.employerDao.getById(id),"Employer listed. Waiting for update");
			}
		}
		return new SuccessDataResult<Employer>(this.employerDao.getById(id),"Employer listed");
	}

	@Override
	public Result add(Employer employer, String passwordAgain) {
		if(! (this.employerCheckService.checkAll(employer, passwordAgain).isSuccess())) {
			return new ErrorResult(this.employerCheckService.checkAll(employer, passwordAgain).getMessage());
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer added succesfully");
	}
	
	@Override
	public Result verifyEmail(int id) {
		if(! (this.emailVerificationService.verifyEmail(this.employerDao.getById(id)).isSuccess())) {
			return new ErrorResult("Email could not be verified");
		}
		this.employerDao.getById(id).setMailVerified(true);
		this.employerDao.save(this.employerDao.getById(id));
		return new SuccessResult("Email verified successfully");
	}
/*
	@Override
	public Result addJobTitle(JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@Override
	public Result makeJobAdvertisementPassive(JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.makePassive(jobAdvertisement);
	}
*/
}
 