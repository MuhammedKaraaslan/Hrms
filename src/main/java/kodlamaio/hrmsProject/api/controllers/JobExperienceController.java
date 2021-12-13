package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.JobExperienceService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperience")
@CrossOrigin
public class JobExperienceController {
	
	private JobExperienceService jobExperienceService;

	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}	
	
	@GetMapping("/getAllByOrderByQuitYearDesc")
	public DataResult<List<JobExperience>> getAllByOrderByQuitYearDesc(){
		return this.jobExperienceService.getAllByOrderByQuitYearDesc();
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.update(jobExperience);
	}

}
