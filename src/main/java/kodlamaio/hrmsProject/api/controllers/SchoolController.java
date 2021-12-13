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

import kodlamaio.hrmsProject.business.abstracts.SchoolService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.School;

@RestController
@RequestMapping("/api/school")
@CrossOrigin
public class SchoolController {

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping("/getAllByCandidateIdOrderByGraduationYearDesc")
	public DataResult<List<School>> getAllByCandidateIdOrderByGraduationYearDesc(@RequestParam int candidateId){
		return this.schoolService.getAllByCandidateIdOrderByGraduationYearDesc(candidateId);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody School school) {
		return this.schoolService.update(school);
	}
}
