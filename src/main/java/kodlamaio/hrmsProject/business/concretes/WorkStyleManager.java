package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.WorkStyleService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.WorkStyleDao;
import kodlamaio.hrmsProject.entities.concretes.WorkStyle;



@Service
public class WorkStyleManager implements WorkStyleService{

	private WorkStyleDao workStyleDao;
	
	@Autowired
	public WorkStyleManager(WorkStyleDao workStyleDao) {
		super();
		this.workStyleDao = workStyleDao;
	}

	@Override
	public DataResult<List<WorkStyle>> getAll() {
		return new SuccessDataResult<List<WorkStyle>>(this.workStyleDao.findAll(), "Work styles listed");
	}

	@Override
	public Result add(WorkStyle workStyle) {
		if(workStyle.getStyle().isEmpty()) {
			return new ErrorResult("Work style can not be empty");
		}
		this.workStyleDao.save(workStyle);
		return new SuccessResult("Work style added");
	}

}
