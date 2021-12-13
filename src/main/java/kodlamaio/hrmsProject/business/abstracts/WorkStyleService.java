package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.WorkStyle;

public interface WorkStyleService {
	DataResult<List<WorkStyle>> getAll();
	Result add(WorkStyle workStyle);
}
