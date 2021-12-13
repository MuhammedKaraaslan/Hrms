package kodlamaio.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.ForeignLanguageService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignLanguage")
@CrossOrigin
public class ForeignLanguageController {

	private ForeignLanguageService foreignLanguageService;
	
	@Autowired
	public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}


	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguage foreignLanguage) {
		return this.foreignLanguageService.add(foreignLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ForeignLanguage foreignLanguage) {
		return this.foreignLanguageService.update(foreignLanguage);
	}

}
