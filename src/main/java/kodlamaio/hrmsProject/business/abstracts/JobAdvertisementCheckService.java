package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementCheckService {
	
	Result checkJobTitle(JobAdvertisement jobAdvertisement);
	Result checkDescription(JobAdvertisement jobAdvertisement);
	Result checkCity(JobAdvertisement jobAdvertisement);
	Result checkSalary(JobAdvertisement jobAdvertisement);
	Result checkOpenPositionNumber(JobAdvertisement jobAdvertisement);
	Result checkDeadline(JobAdvertisement jobAdvertisement);
	Result checkWorkStlye(JobAdvertisement jobAdvertisement);
	Result checkWorkTime(JobAdvertisement jobAdvertisement);
	Result checkAll(JobAdvertisement jobAdvertisement);
	
}
