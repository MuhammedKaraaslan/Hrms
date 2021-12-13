package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployerUpdateService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.hrmsProject.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService{

	private EmployerUpdateDao employerUpdateDao;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao, EmployerDao employerDao) {
		super();
		this.employerUpdateDao = employerUpdateDao;
		this.employerDao = employerDao;
	}
	
	@Override
	public Result checkRules(EmployerUpdate employerUpdate) {
		if(this.employerDao.findByEmail(employerUpdate.getEmail()).isSuccess()) {
			return new ErrorResult("This email is invalid");
		}
		else if(this.employerDao.findByCompanyName(employerUpdate.getCompanyName()).isSuccess()) {
			return new ErrorResult("This company name is invalid");
		}
		else if(this.employerDao.findByWebAddress(employerUpdate.getWebAddress()).isSuccess()) {
			return new ErrorResult("This web address is invalid");
		}
		else if(this.employerDao.findByPhoneNumber(employerUpdate.getPhoneNumber()).isSuccess()) {
			return new ErrorResult("This phone number is invalid");
		}
		// Mail domain, phone number etc. should be controlled.
		return new SuccessResult();
	}

	@Override
	public Result add(EmployerUpdate employerUpdate) {
		if(! checkRules(employerUpdate).isSuccess()) {
			return new ErrorResult(checkRules(employerUpdate).getMessage());
		}
		this.employerUpdateDao.save(employerUpdate);
		return new SuccessResult("Employer update added");
	}

	@Override
	public Result confirmEmployerUpdates(EmployerUpdate employerUpdate) {
		this.employerDao.getById(employerUpdate.getUserId()).setEmail(employerUpdate.getEmail());
		this.employerDao.getById(employerUpdate.getUserId()).setPassword(employerUpdate.getPassword());
		this.employerDao.getById(employerUpdate.getUserId()).setCompanyName(employerUpdate.getCompanyName());
		this.employerDao.getById(employerUpdate.getUserId()).setWebAddress(employerUpdate.getWebAddress());
		this.employerDao.getById(employerUpdate.getUserId()).setPhoneNumber(employerUpdate.getPhoneNumber());
		this.employerDao.save(this.employerDao.getById(employerUpdate.getUserId()));
		this.employerUpdateDao.deleteById(employerUpdate.getId());
		return new SuccessResult("Employer's updates confirmed");
	}

}
