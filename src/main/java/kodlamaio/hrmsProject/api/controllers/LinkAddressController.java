package kodlamaio.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.LinkAddressesService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.LinkAddress;

@RestController
@RequestMapping("/api/linkAddress")
@CrossOrigin
public class LinkAddressController {

	private LinkAddressesService linkAddressesService;

	@Autowired
	public LinkAddressController(LinkAddressesService linkAddressesService) {
		super();
		this.linkAddressesService = linkAddressesService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LinkAddress linkAddress) {
		return this.linkAddressesService.add(linkAddress);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody LinkAddress linkAddress) {
		return this.linkAddressesService.update(linkAddress);
	}
	
}
