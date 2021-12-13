package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;




public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getById(int id);
	Result add(Employer employer, String passwordAgain);
	Result verifyEmail(int id);
	//Result addJobTitle(JobTitle jobTitle);
	//Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
	//Result makeJobAdvertisementPassive(JobAdvertisement jobAdvertisement);
}
