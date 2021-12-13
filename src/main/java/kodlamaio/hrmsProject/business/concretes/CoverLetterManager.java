package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.CoverLetterService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	private CandidateDao candidateDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao, CandidateDao candidateDao) {
		super();
		this.coverLetterDao = coverLetterDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result checkCandidate(CoverLetter coverLetter) {
		if(this.candidateDao.getById(coverLetter.getCandidate().getId()) == null) {
			return new ErrorResult("This candidate id is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkDetails(CoverLetter coverLetter) {
		if(coverLetter.getDetail().isEmpty()) {
			return new ErrorResult("Details can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkAll(CoverLetter coverLetter) {
		if(! checkCandidate(coverLetter).isSuccess()) {
			return new ErrorResult(checkCandidate(coverLetter).getMessage());
		}
		else if(! checkDetails(coverLetter).isSuccess()){
			return new ErrorResult(checkDetails(coverLetter).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		if(! checkAll(coverLetter).isSuccess()) {
			return new ErrorResult(checkAll(coverLetter).getMessage());
		}
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter added succesfully");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter updated");
	}



}
