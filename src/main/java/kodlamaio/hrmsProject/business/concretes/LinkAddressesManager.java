package kodlamaio.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrmsProject.business.abstracts.LinkAddressesService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.LinkAddressDao;
import kodlamaio.hrmsProject.entities.concretes.LinkAddress;

@Service
public class LinkAddressesManager implements LinkAddressesService{

	private LinkAddressDao linkAddressDao;
	private CandidateDao candidateDao;
	
	@Autowired	
	public LinkAddressesManager(LinkAddressDao linkAddressDao, CandidateDao candidateDao) {
		super();
		this.linkAddressDao = linkAddressDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result checkCandidate(LinkAddress linkAddress) {
		if(this.candidateDao.getById(linkAddress.getCandidate().getId()) == null) {
			return new ErrorResult("This candidate id is invalid");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkTitle(LinkAddress linkAddress) {
		if(linkAddress.getTitle().isEmpty()) {
			return new ErrorResult("Title can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkAddresses(LinkAddress linkAddress) {
		if(linkAddress.getAddress().isEmpty()) {
			return new ErrorResult("Address can not be empty");
		} 
		return new SuccessResult();
	}


	@Override
	public Result checkAll(LinkAddress linkAddress) {
		if(! checkCandidate(linkAddress).isSuccess()) {
			return new ErrorResult(checkCandidate(linkAddress).getMessage());
		}
		else if(! checkTitle(linkAddress).isSuccess()) {
			return new ErrorResult(checkTitle(linkAddress).getMessage());
		}
		else if(! checkAddresses(linkAddress).isSuccess()) {
			return new ErrorResult(checkAddresses(linkAddress).getMessage());
		}
		return new SuccessResult();
	}

	@Override
	public Result add(LinkAddress linkAddress) {
		if(! checkAll(linkAddress).isSuccess()) {
			return new ErrorResult(checkAll(linkAddress).getMessage());
		}
		this.linkAddressDao.save(linkAddress);
		return new SuccessResult("Link addresses added succesfully");
	}

	@Override
	public Result update(LinkAddress linkAddress) {
		this.linkAddressDao.save(linkAddress);
		return new SuccessResult("Link address updated");
	}

}
