package kodlamaio.hrmsProject.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsProject.business.abstracts.PhotoService;
import kodlamaio.hrmsProject.core.adapters.abstracts.CloudinaryService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrmsProject.entities.concretes.Photo;



@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryservice;

	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryservice) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryservice = cloudinaryservice;
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		return new SuccessDataResult<>(this.photoDao.findAll(),"All photos listed");
	}

	@Override
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException {
		Result result = new ErrorResult("Photo could not be added");
		Map photoMap = cloudinaryservice.photoUpload(multipartFile);
		photo.setPhotoUrl(photoMap.get("url").toString());
		this.photoDao.save(photo);
		return result;
	}

	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryservice.photoDelete(id);
		return new SuccessResult("Photo deleted");
	}

	@Override
	public Result update(int cvId, MultipartFile multipartFile) throws IOException {
		Map photoMap = cloudinaryservice.photoUpload(multipartFile);
		this.photoDao.updatePhotoSetPhotoUrlForCandidate_id(photoMap.get("url").toString(), cvId);
		return new SuccessResult("Photo updated");
	}

	@Override
	public DataResult<Photo> getByPhotoCandidate_Id(int cvId) {
		return new SuccessDataResult<Photo>(this.photoDao.getByPhotoCandidate_Id(cvId), 
				"Photos listed");
	}
}
