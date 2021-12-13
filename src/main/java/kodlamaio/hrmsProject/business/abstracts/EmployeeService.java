package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employee;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

public interface EmployeeService {
	
	Result checkEmailAddress(Employee employee);
	Result checkPassword(Employee employee, String passwordAgain);
	Result checkFirstName(Employee employee);
	Result checkLastName(Employee employee);
	Result checkAll(Employee employee, String passwordAgain);
	Result add(Employee employee, String passwordAgain);
	DataResult<List<Employee>> getAll();	
	Result confrimEmployer(Employer employer);
	Result confirmJobAdvertisement(JobAdvertisement jobAdvertisement);
	Result update(Employee employee);
}
