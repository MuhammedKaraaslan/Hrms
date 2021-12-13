package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.WorkStyleService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.WorkStyle;



@RestController
@RequestMapping("/api/workStyles")
@CrossOrigin
public class WorkStyleController {

	
	private WorkStyleService workStyleService;

	@Autowired
	public WorkStyleController(WorkStyleService workStyleService) {
		super();
		this.workStyleService = workStyleService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<WorkStyle>> getAll(){
		return this.workStyleService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkStyle workStyle) {
		return this.workStyleService.add(workStyle);
	}
	
}
