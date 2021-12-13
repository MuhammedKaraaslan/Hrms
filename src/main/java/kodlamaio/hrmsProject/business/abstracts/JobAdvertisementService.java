package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result makePassive(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive);
	DataResult<List<JobAdvertisement>> getByIsActiveOrderByDeadlineDate();
	DataResult<List<JobAdvertisement>> getActiveAdvertisementsOfAnEmployer(int employerId);
	DataResult<JobAdvertisement> getById(int jobAdvertisementId);
}
