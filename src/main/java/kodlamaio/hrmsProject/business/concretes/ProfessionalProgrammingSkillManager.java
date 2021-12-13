package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.ProfessionalProgrammingSkillService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.ProfessionalProgrammingSkillDao;
import kodlamaio.hrmsProject.entities.concretes.ProfessionalProgrammingSkill;

@Service
public class ProfessionalProgrammingSkillManager implements ProfessionalProgrammingSkillService{

	private ProfessionalProgrammingSkillDao professionalProgrammingSkillDao;
	private CandidateDao candidateDao;
	
	@Autowired
	public ProfessionalProgrammingSkillManager(ProfessionalProgrammingSkillDao professionalProgrammingSkillDao, CandidateDao candidateDao) {
		super();
		this.professionalProgrammingSkillDao = professionalProgrammingSkillDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result checkCandidate(ProfessionalProgrammingSkill proffesionalProgrammingSkill) {
		if(this.candidateDao.getById(proffesionalProgrammingSkill.getCandidate().getId()) == null) {
			return new ErrorResult("This candidate id is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkName(ProfessionalProgrammingSkill proffesionalProgrammingSkill) {
		if(proffesionalProgrammingSkill.getName().isEmpty()) {
			return new ErrorResult("Name can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkAll(ProfessionalProgrammingSkill proffesionalProgrammingSkill) {
		if(! checkCandidate(proffesionalProgrammingSkill).isSuccess()) {
			return new ErrorResult(checkCandidate(proffesionalProgrammingSkill).getMessage());
		}
		else if(! checkName(proffesionalProgrammingSkill).isSuccess()) {
			return new ErrorResult(checkName(proffesionalProgrammingSkill).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result add(ProfessionalProgrammingSkill proffesionalProgrammingSkill) {
		if(! checkAll(proffesionalProgrammingSkill).isSuccess()) {
			return new ErrorResult(checkAll(proffesionalProgrammingSkill).getMessage());
		}
		this.professionalProgrammingSkillDao.save(proffesionalProgrammingSkill);
		return new SuccessResult("Skill added successfully");
	}

	@Override
	public Result update(ProfessionalProgrammingSkill proffesionalProgrammingSkill) {
		this.professionalProgrammingSkillDao.save(proffesionalProgrammingSkill);
		return new SuccessResult("Skill updated");
	}

}
