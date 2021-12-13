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

import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(
			kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/makePassive")
	public Result makePassive(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.makePassive(jobAdvertisement);
	} 
	
	@GetMapping("/getActiveAdvertisements")
	public DataResult<List<JobAdvertisement>> getByIsActive(){
		//Tüm liste dönüyor fakat belirli özelliklerin dönmesi isteniyor.
		//İlerleyen zamanda düzenlenecek.
		return this.jobAdvertisementService.getByIsActive(true);
	} 
	
	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam int jobAdvertisementId){
		return this.jobAdvertisementService.getById(jobAdvertisementId);
	}
	
	@GetMapping("/getActiveAdvertisementsWithDeadlineOrder")
	public DataResult<List<JobAdvertisement>> getByIsActiveOrderByDeadlineDate(){
		//Tüm liste dönüyor fakat belirli özelliklerin dönmesi isteniyor.
		//İlerleyen zamanda düzenlenecek.
		return this.jobAdvertisementService.getByIsActiveOrderByDeadlineDate();
	}
	
	@GetMapping("/getActiveAdvertisementsOfAnEmployer")
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsOfAnEmployer(@RequestParam int employerId){
		return this.jobAdvertisementService.getActiveAdvertisementsOfAnEmployer(employerId);
	}
}
