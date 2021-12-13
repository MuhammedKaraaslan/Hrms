package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.WorkTimeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrmsProject.entities.concretes.WorkTime;


@Service
public class WorkTimeManager implements WorkTimeService{

	private WorkTimeDao workTimeDao;
	
	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		super();
		this.workTimeDao = workTimeDao;
	}

	@Override
	public DataResult<List<WorkTime>> getAll() {
		return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.findAll());
	}

	@Override
	public Result add(WorkTime workTime) {
		if(workTime.getTime().isEmpty()) {
			return new ErrorResult("Time can not be empty");
		}
		this.workTimeDao.save(workTime);
		return new SuccessResult("Work time added");
	}

}
