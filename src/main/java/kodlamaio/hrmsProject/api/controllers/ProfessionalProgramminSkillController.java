package kodlamaio.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.ProfessionalProgrammingSkillService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.ProfessionalProgrammingSkill;

@RestController
@RequestMapping("/api/professionalProgrammingSkill")
@CrossOrigin
public class ProfessionalProgramminSkillController {

	private ProfessionalProgrammingSkillService professionalProgrammingSkillService;

	@Autowired
	public ProfessionalProgramminSkillController(
			ProfessionalProgrammingSkillService professionalProgrammingSkillService) {
		super();
		this.professionalProgrammingSkillService = professionalProgrammingSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProfessionalProgrammingSkill professionalProgrammingSkill) {
		return this.professionalProgrammingSkillService.add(professionalProgrammingSkill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ProfessionalProgrammingSkill professionalProgrammingSkill) {
		return this.professionalProgrammingSkillService.update(professionalProgrammingSkill);
	}
}
