package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.WorkTimeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.WorkTime;



@RestController
@RequestMapping("/api/workTimes") // Dış dünyadan biri /api/jobtitles isteği gönderirse bu controller çalışacak.
@CrossOrigin
public class WorkTimeController {
	
	private WorkTimeService workTimeService;

	@Autowired
	public WorkTimeController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}

	@GetMapping("/getAll") // Dış dünyadan biri /api/jobtitles/getall isteği gönderirse bu method çalışacak.
	public DataResult<List<WorkTime>> getAll(){
		return this.workTimeService.getAll();
	}
	
	@PostMapping("/add") // Dış dünyadan biri /api/jobtitles/add isteği gönderirse bu method çalışacak.
	public Result add(@RequestBody WorkTime workTime) {
		return this.workTimeService.add(workTime);
	} 

}
