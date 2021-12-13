package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao  extends JpaRepository<ForeignLanguage, Integer>{
	
	ForeignLanguage getById(int id);
}
