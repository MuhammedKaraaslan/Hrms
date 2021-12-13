package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.ProfessionalProgrammingSkill;

public interface ProfessionalProgrammingSkillDao extends JpaRepository<ProfessionalProgrammingSkill, Integer>{
	ProfessionalProgrammingSkill getById(int id);
}
