package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.ProfessionalProgrammingSkill;

public interface ProfessionalProgrammingSkillService {
	Result checkCandidate(ProfessionalProgrammingSkill proffesionalProgrammingSkill);
	Result checkName(ProfessionalProgrammingSkill proffesionalProgrammingSkill);
	Result checkAll(ProfessionalProgrammingSkill proffesionalProgrammingSkill);
	Result add(ProfessionalProgrammingSkill proffesionalProgrammingSkill);
	Result update(ProfessionalProgrammingSkill proffesionalProgrammingSkill);
}
