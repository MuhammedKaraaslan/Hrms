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

import kodlamaio.hrmsProject.business.abstracts.FavoriteJobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.FavoriteJobAdvertisement;

@RestController
@RequestMapping("/api/favoriteJobAdvertisements")
@CrossOrigin
public class FavoriteJobAdvertisementController {

	private FavoriteJobAdvertisementService favoriteJobAdvertisementService;

	@Autowired
	public FavoriteJobAdvertisementController(FavoriteJobAdvertisementService favoriteJobAdvertisementService) {
		super();
		this.favoriteJobAdvertisementService = favoriteJobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobAdvertisement favoriteJobAdvertisement) {
		return this.favoriteJobAdvertisementService.add(favoriteJobAdvertisement);
	}
	
	@GetMapping
	public DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(@RequestParam int candidateId){
		return this.favoriteJobAdvertisementService.getByCandidateId(candidateId);
	}
	
}
