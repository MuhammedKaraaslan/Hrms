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

import kodlamaio.hrmsProject.business.abstracts.EmployeeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employee;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;



@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee, @RequestParam String passwordAgain) {
		return this.employeeService.add(employee, passwordAgain);
	}
	
	@PostMapping("/confirmEmployer")
	public Result confrimEmployer(@RequestBody Employer employer) {
		return this.employeeService.confrimEmployer(employer);
	}
	
	@PostMapping("/confirmJobAdvertisement")
	public Result confirmJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.employeeService.confirmJobAdvertisement(jobAdvertisement);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Employee employee) {
		return this.employeeService.update(employee);
	}

}
