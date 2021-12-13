package kodlamaio.hrmsProject.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrmsProject.entities.concretes.CoverLetter;
import kodlamaio.hrmsProject.entities.concretes.ForeignLanguage;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;
import kodlamaio.hrmsProject.entities.concretes.LinkAddress;
import kodlamaio.hrmsProject.entities.concretes.Photo;
import kodlamaio.hrmsProject.entities.concretes.ProfessionalProgrammingSkill;
import kodlamaio.hrmsProject.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class CandidateCvDto {

	private int id;
	
	@JsonIgnoreProperties({"candidate"}) 
	private List<School> schools;
	
	@JsonIgnoreProperties({"candidate"}) 
	private List<JobExperience> jobExperiences;
	
	@JsonIgnoreProperties({"candidate"}) 
	private List<ForeignLanguage> foreignLanguages;
	
	@JsonIgnoreProperties({"candidate"}) 
	private List<Photo> photos;
	
	@JsonIgnoreProperties({"candidate"}) 
	private List<LinkAddress> linkAddresses;

	@JsonIgnoreProperties({"candidate"}) 
	private List<ProfessionalProgrammingSkill> professionalProgrammingSkills;
	
	@JsonIgnoreProperties({"candidate"}) 
	private List<CoverLetter> coverLetters;
		
}
 