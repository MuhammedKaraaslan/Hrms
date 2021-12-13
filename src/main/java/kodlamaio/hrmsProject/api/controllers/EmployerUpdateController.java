package kodlamaio.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.EmployerUpdateService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerUpdateController {

	private EmployerUpdateService employerUpdateService;

	@Autowired
	public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}
	
	
	@PostMapping("/updateEmployer")
	public Result add(@RequestBody EmployerUpdate employerUpdate) {
		return this.employerUpdateService.add(employerUpdate);
	}
	
	@PostMapping("/confirmEmployerUpdates")
	public Result confirmEmployerUpdates(@RequestBody EmployerUpdate employerUpdate) {
		return this.employerUpdateService.confirmEmployerUpdates(employerUpdate);
	}
	
}
