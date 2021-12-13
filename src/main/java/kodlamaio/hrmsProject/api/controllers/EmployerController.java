package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;


@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
	
	private EmployerService employerService;
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public EmployerController(EmployerService employerService, JobAdvertisementService jobAdvertisementService) {
		super();
		this.employerService = employerService;
		this.jobAdvertisementService = jobAdvertisementService;
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer, @RequestParam String passwordAgain) {
		return this.employerService.add(employer, passwordAgain);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(@RequestParam int id){
		return this.employerService.getById(id);
	}
	
	@PostMapping("/verifyEmail")
	public Result verifyEmail(@RequestBody Employer employer) {
		return this.employerService.verifyEmail(employer.getId());
	}
	
	@PostMapping("/addJobAdvertisement")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/makeJobAdvertisementPassive")
	public Result makePassive(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.makePassive(jobAdvertisement);
	}
}
