package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.FavoriteJobAdvertisement;

public interface FavoriteJobAdvertisementService{

	Result add(FavoriteJobAdvertisement favoriteJobAdvertisement);
	DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(int id);
}
