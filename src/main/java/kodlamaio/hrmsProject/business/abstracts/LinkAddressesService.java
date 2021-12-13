package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.LinkAddress;

public interface LinkAddressesService {
	Result checkCandidate(LinkAddress linkAddress);
	Result checkTitle(LinkAddress linkAddress);
	Result checkAddresses(LinkAddress linkAddress);
	Result checkAll(LinkAddress linkAddress);
	Result add(LinkAddress linkAddress);
	Result update(LinkAddress linkAddress);
}
