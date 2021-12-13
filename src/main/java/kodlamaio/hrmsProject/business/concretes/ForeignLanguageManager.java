package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.ForeignLanguageService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrmsProject.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{

	private ForeignLanguageDao foreignLanguageDao;
	private CandidateDao candidateDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, CandidateDao candidateDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result checkCandidate(ForeignLanguage foreignLanguage) {
		if(this.candidateDao.getById(foreignLanguage.getCandidate().getId()) == null) {
			return new ErrorResult("This candidate id is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkName(ForeignLanguage foreignLanguage) {
		if(foreignLanguage.getName().isEmpty()) {
			return new ErrorResult("Name can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkLevel(ForeignLanguage foreignLanguage) {
		if(foreignLanguage.getLevel().isEmpty()) {
			return new ErrorResult("Level can not be empty");
		}
		else if(Integer.parseInt(foreignLanguage.getLevel()) > 5) {
			return new ErrorResult("Level can not bigger than 5");
		}
		else if(Integer.parseInt(foreignLanguage.getLevel()) < 1) {
			return new ErrorResult("Level can not less than 1");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkAll(ForeignLanguage foreignLanguage) {
		if(! checkCandidate(foreignLanguage).isSuccess()) {
			return new ErrorResult(checkCandidate(foreignLanguage).getMessage());
		}
		else if(! checkName(foreignLanguage).isSuccess()) {
			return new ErrorResult(checkName(foreignLanguage).getMessage());
		}
		else if(! checkLevel(foreignLanguage).isSuccess()) {
			return new ErrorResult(checkLevel(foreignLanguage).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		if(! checkAll(foreignLanguage).isSuccess()) {
			return new ErrorResult(checkAll(foreignLanguage).getMessage());
		}
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Foreign lanugage added successfully");
	}

	@Override
	public Result update(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Foreign language updated");
	}

}
