package kodlamaio.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.FavoriteJobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.FavoriteJobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.FavoriteJobAdvertisement;

@Service
public class FavoriteJobAdvertisementManager implements FavoriteJobAdvertisementService{

	private FavoriteJobAdvertisementDao favoriteJobAdvertisementDao;
	
	@Autowired
	public FavoriteJobAdvertisementManager(FavoriteJobAdvertisementDao favoriteJobAdvertisementDao) {
		super();
		this.favoriteJobAdvertisementDao = favoriteJobAdvertisementDao;
	}

	@Override
	public Result add(FavoriteJobAdvertisement favoriteJobAdvertisement) {
		this.favoriteJobAdvertisementDao.save(favoriteJobAdvertisement);
		return new SuccessResult("Job advertisement added to favorite");
	}

	@Override
	public DataResult<List<FavoriteJobAdvertisement>> getByCandidateId(int id) {
		return new SuccessDataResult<List<FavoriteJobAdvertisement>>(this.favoriteJobAdvertisementDao.getByCandidateId(id), "Favorite job advertisements listed");
	}

}
