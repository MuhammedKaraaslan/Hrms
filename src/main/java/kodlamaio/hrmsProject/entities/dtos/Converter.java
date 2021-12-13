package kodlamaio.hrmsProject.entities.dtos;

import org.springframework.stereotype.Component;

import kodlamaio.hrmsProject.entities.concretes.Candidate;


@Component
public class Converter {
	
	public CandidateCvDto convertToCv(Candidate candidate) {
		return new CandidateCvDto(candidate.getId(), candidate.getSchools(),
				candidate.getJobExperiences(), candidate.getForeignLanguages(), candidate.getPhotos(),
				candidate.getLinkAddresses(), candidate.getProfessionalProgrammingSkills(), candidate.getCoverLetters());
	}
}
