package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.CandidateCheckService;
import kodlamaio.hrmsProject.core.adapters.abstracts.MernisCheckService;
import kodlamaio.hrmsProject.core.utilities.abstracts.SignUpCheckService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{
	
	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private SignUpCheckService signUpCheckService;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao, MernisCheckService mernisCheckService,
			SignUpCheckService signUpCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisCheckService = mernisCheckService;
		this.signUpCheckService = signUpCheckService;
	}

	@Override
	public Result checkFirstName(Candidate candidate) {
		if(candidate.getFirstName().isEmpty()) {
			return new ErrorResult("First name can not be empty");
		}
		else if(candidate.getFirstName().length() < 2) {
			return new ErrorResult("First name can not be less than 2 characters");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkLastName(Candidate candidate) {
		if(candidate.getLastName().isEmpty()) {
			return new ErrorResult("Last name can not be empty");
		}
		else if(candidate.getLastName().length() < 2) {
			return new ErrorResult("Last name can not be less than 2 characters");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkUniqueIdentityNumber(Candidate candidate) {
		for (Candidate candidateFromDao : this.candidateDao.findAll()) {
			if(candidateFromDao.getIdentityNumber().equals(candidate.getIdentityNumber())) {
				return new ErrorResult("This identity number is already used");
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkMernis(Candidate candidate) {
		if(! this.mernisCheckService.checkIfRealPerson(candidate).isSuccess()) {
			return new ErrorResult("Error in mernis check");
		}
		else {
			return new SuccessResult();
		}
	}

	@Override
	public Result checkBirthYear(Candidate candidate) {
		if(candidate.getBirthYear() < 1900 || candidate.getBirthYear() > 2021) {
			return new ErrorResult("Birth year should be between 1900 and 2021");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkEmailAdress(Candidate candidate) {
		if(! this.signUpCheckService.checkEmailFormat(candidate).isSuccess()) {
			return new ErrorResult("Wrong email adress");
		}
		else if(! this.signUpCheckService.checkUniqueEmail(candidate).isSuccess()) {
			return new ErrorResult("That email adress is used");
		}
		
		return new SuccessResult();
	}	

	@Override
	public Result checkPassword(Candidate candidate, String passwordAgain) {
		if(! (this.signUpCheckService.checkPassword(candidate, passwordAgain).isSuccess())) {
			return new ErrorResult(this.signUpCheckService.checkPassword(candidate, passwordAgain).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result checkAll(Candidate candidate, String passwordAgain) {
		if(! checkFirstName(candidate).isSuccess()) {
			return new ErrorResult(checkFirstName(candidate).getMessage());
		}
		else if(! checkLastName(candidate).isSuccess()) {
			return new ErrorResult(checkLastName(candidate).getMessage());
		}
		else if(! checkUniqueIdentityNumber(candidate).isSuccess()) {
			return new ErrorResult(checkUniqueIdentityNumber(candidate).getMessage());
		}
		else if(! checkMernis(candidate).isSuccess()) {
			return new ErrorResult(checkMernis(candidate).getMessage());
		}
		else if(! checkBirthYear(candidate).isSuccess()) {
			return new ErrorResult(checkBirthYear(candidate).getMessage());
		}
		else if(! checkEmailAdress(candidate).isSuccess()) {
			return new ErrorResult(checkEmailAdress(candidate).getMessage());
		}
		else if(! checkPassword(candidate, passwordAgain).isSuccess()) {
			return new ErrorResult(checkPassword(candidate, passwordAgain).getMessage());
		}
		return new SuccessResult();
	}

}
