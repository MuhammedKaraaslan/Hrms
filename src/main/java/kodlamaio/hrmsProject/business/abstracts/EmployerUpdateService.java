package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {

	Result checkRules(EmployerUpdate employerUpdate);
	Result add(EmployerUpdate employerUpdate);
	Result confirmEmployerUpdates(EmployerUpdate employerUpdate);
}
