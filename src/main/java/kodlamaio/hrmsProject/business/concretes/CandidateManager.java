package kodlamaio.hrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.CandidateService;
import kodlamaio.hrmsProject.core.utilities.abstracts.EmailVerificationService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.entities.concretes.Candidate;
import kodlamaio.hrmsProject.entities.dtos.CandidateCvDto;
import kodlamaio.hrmsProject.entities.dtos.Converter;


@Service //Spring'e bu class service görevi görecek diye bildiriyoruz. 
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private CandidateCheckManager candidateCheckManager;
	private EmailVerificationService emailVerificationService;
	private Converter converter;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckManager candidateCheckManager,
			EmailVerificationService emailVerificationService, Converter converter) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckManager = candidateCheckManager;
		this.emailVerificationService = emailVerificationService;
		this.converter = converter;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed");
	}
	
	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId), "Candidate listed");
	}

	@Override
	public Result add(Candidate candidate, String passwordAgain) { 
		if(this.candidateCheckManager.checkAll(candidate, passwordAgain).isSuccess()) {
			this.candidateDao.save(candidate);
			return new SuccessResult("Candidate added successfully");			
		}
		return new ErrorResult(this.candidateCheckManager.checkAll(candidate, passwordAgain).getMessage());
	}

	@Override
	public Result verifyEmail(int id) {
		if(! (this.emailVerificationService.verifyEmail(this.candidateDao.getById(id)).isSuccess())) {
			return new ErrorResult("Email could not be verified");
		}
		this.candidateDao.getById(id).setMailVerified(true);
		this.candidateDao.getById(id).setActive(true);
		this.candidateDao.save(this.candidateDao.getById(id));
		return new SuccessResult("Email verified successfully. Candidate is active now");
	}
	
	@Override
	public DataResult<List<CandidateCvDto>> getCandidateWithCvDetails(int candidateId) {
		return new SuccessDataResult<List<CandidateCvDto>>(this.candidateDao.findById(candidateId)
				.stream()
				.map(converter::convertToCv)
				.collect(Collectors.toList()),"Cv details listed");
	}


}
