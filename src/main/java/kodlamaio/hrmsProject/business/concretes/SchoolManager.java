package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrmsProject.business.abstracts.SchoolService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrmsProject.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	private CandidateDao candidateDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao, CandidateDao candidateDao) {
		super();
		this.schoolDao = schoolDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result checkCandidate(School school) {
		if(this.candidateDao.getById(school.getCandidate().getId()) == null) {
			return new ErrorResult("This cv id is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkName(School school) {
		if(school.getName().isEmpty()) {
			return new ErrorResult("Name can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkDepartment(School school) {
		if(school.getDepartment().isEmpty()) {
			return new ErrorResult("Department can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkEntryYear(School school) {
		if(school.getEntryYear().isEmpty()) {
			return new ErrorResult("Entry year can not be empty");
		}
		else if(! school.getGraduationYear().isEmpty()) {
			if(Integer.parseInt(school.getEntryYear()) >= Integer.parseInt(school.getGraduationYear())) {
				return new ErrorResult("Entry year should be less than graduation year");
			}
		}		
		return new SuccessResult();
		
	}

	@Override
	public Result checkAll(School school) {
		if(! checkCandidate(school).isSuccess()) {
			return new ErrorResult(checkCandidate(school).getMessage());
		}
		else if(! checkName(school).isSuccess()) {
			return new ErrorResult(checkName(school).getMessage());
		}
		else if(! checkDepartment(school).isSuccess()) {
			return new ErrorResult(checkDepartment(school).getMessage());
		}
		else if(! checkEntryYear(school).isSuccess()) {
			return new ErrorResult(checkEntryYear(school).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result add(School school) {
		if(! checkAll(school).isSuccess()) {
			return new ErrorResult(checkAll(school).getMessage());
		}
		this.schoolDao.save(school);
		return new SuccessResult("School information added");
	}

	@Override
	public DataResult<List<School>> getAllByCandidateIdOrderByGraduationYearDesc(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCandidateIdOrderByGraduationYearDesc(id));
	}

	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School updated");
	} 

}
