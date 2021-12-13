package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.WorkTime;


public interface WorkTimeService {
	DataResult<List<WorkTime>> getAll();
	Result add(WorkTime workTime);
}
