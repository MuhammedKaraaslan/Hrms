package kodlamaio.hrmsProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Photo;

public interface PhotoService {
	public DataResult<List<Photo>> getAll();	
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException;	
	public Result update(int cvId, MultipartFile multipartFile) throws IOException;	
	public Result delete(String id) throws IOException;	
	public DataResult<Photo> getByPhotoCandidate_Id(int id);
}