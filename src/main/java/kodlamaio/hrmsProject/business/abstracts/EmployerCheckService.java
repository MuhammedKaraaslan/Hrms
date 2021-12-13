package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;

public interface EmployerCheckService {
	Result checkCompanyName(Employer employer);
	Result checkWebAddress(Employer employer); 
	Result checkMailDomain(Employer employer); 
	Result checkEmail(Employer employer);
	Result checkPhoneNumber(Employer employer); 
	Result checkPassword(Employer employer, String passwordAgain); 
	Result checkAll(Employer employer, String passwordAgain);
}
