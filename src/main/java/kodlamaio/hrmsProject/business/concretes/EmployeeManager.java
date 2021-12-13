package kodlamaio.hrmsProject.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployeeService;
import kodlamaio.hrmsProject.core.utilities.abstracts.SignUpCheckService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.Employee;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private SignUpCheckService signUpCheckService;
	private EmployerDao employerDao;
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, SignUpCheckService signUpCheckService,
			EmployerDao employerDao, JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.employeeDao = employeeDao;
		this.signUpCheckService = signUpCheckService;
		this.employerDao = employerDao;
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result checkEmailAddress(Employee employee) {
		if(! this.signUpCheckService.checkEmailFormat(employee).isSuccess()) {
			return new ErrorResult("Wrong email adress");
		}
		else if(! this.signUpCheckService.checkUniqueEmail(employee).isSuccess()) {
			return new ErrorResult("That email adress is used");
		}
		
		return new SuccessResult();
	}	

	@Override
	public Result checkPassword(Employee employee, String passwordAgain) {
		if(! (this.signUpCheckService.checkPassword(employee, passwordAgain).isSuccess())) {
			return new ErrorResult(this.signUpCheckService.checkPassword(employee, passwordAgain).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result checkFirstName(Employee employee) {
		if(employee.getFirstName().isEmpty()) {
			return new ErrorResult("First name can not be empty");
		}
		else if(employee.getFirstName().length() < 2) {
			return new ErrorResult("First name can not be less than 2 characters");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkLastName(Employee employee) {
		if(employee.getLastName().isEmpty()) {
			return new ErrorResult("Last name can not be empty");
		}
		else if(employee.getLastName().length() < 2) {
			return new ErrorResult("Last name can not be less than 2 characters");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkAll(Employee employee, String passwordAgain) {
		if(! (checkEmailAddress(employee).isSuccess())) {
			return new ErrorResult(checkEmailAddress(employee).getMessage());
		}
		else if(! (checkPassword(employee, passwordAgain).isSuccess())) {
			return new ErrorResult(checkPassword(employee,passwordAgain).getMessage());
		}
		else if(! (checkFirstName(employee).isSuccess())) {
			return new ErrorResult(checkFirstName(employee).getMessage());
		}
		else if(! (checkLastName(employee).isSuccess())) {
			return new ErrorResult(checkLastName(employee).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result add(Employee employee, String passwordAgain) {
		if(! (checkAll(employee, passwordAgain).isSuccess())) {
			return new ErrorResult(checkAll(employee, passwordAgain).getMessage());
		}
		this.employeeDao.save(employee);
		return new SuccessResult("Employee added successfully");
	}
	
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "Employees listed");
	}

	@Override
	public Result confrimEmployer(Employer employer) {
		this.employerDao.getById(employer.getId()).setConfirmed(true);
		this.employerDao.getById(employer.getId()).setActive(true);
		this.employerDao.save(this.employerDao.getById(employer.getId()));
		return new SuccessResult("Employer has confirmed. Employer is active now");
	}

	@Override
	public Result confirmJobAdvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.getById(jobAdvertisement.getId()).setConfirmed(true);
		Date date=new Date();  
		this.jobAdvertisementDao.getById(jobAdvertisement.getId()).setConfirmDate(date);
		this.jobAdvertisementDao.save(this.jobAdvertisementDao.getById(jobAdvertisement.getId()));
		return new SuccessResult("Job Advertisement has confirmed");
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Employee updated");
	}




}
