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


import kodlamaio.hrmsProject.business.abstracts.CandidateService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Candidate;
import kodlamaio.hrmsProject.entities.dtos.CandidateCvDto;



@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {

	private CandidateService candidateService;
	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate, @RequestParam String passwordAgain) {
		return this.candidateService.add(candidate, passwordAgain);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Candidate> getById(@RequestParam int candidateId){
		return this.candidateService.getById(candidateId);
	}
	
	@PostMapping("/verifyEmail")
	public Result verifyEmail(@RequestBody Candidate candidate) {
		return this.candidateService.verifyEmail(candidate.getId());
	}
	
	@GetMapping("/getCandidateWithCvDetails")
	public DataResult<List<CandidateCvDto>> getCandidateWithCvDetails(@RequestParam int candidateId){
		return this.candidateService.getCandidateWithCvDetails(candidateId);
	}
}
