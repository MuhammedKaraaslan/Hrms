package kodlamaio.hrmsProject.api.controllers;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsProject.business.abstracts.PhotoService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photo")
@CrossOrigin
public class PhotoController {

	PhotoService photoService;

	@Autowired
	public PhotoController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Photo>> getAll(){
		return this.photoService.getAll();
	}
	@GetMapping("/getByPhotoForCandidateId")
	public DataResult<Photo> getByPhotoForCandidateId(@RequestParam int cvId){
		return this.photoService.getByPhotoCandidate_Id(cvId);
	}
	
	@PostMapping("/addPhoto")
	public ResponseEntity<?> upload(@ModelAttribute("photo") Photo photo,@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.photoService.add(photo, multipartFile), HttpStatus.OK);
	}
	
	@PostMapping("/updatePhoto")
	@Transactional
	public ResponseEntity<?> update(int cvId, MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.photoService.update(cvId, multipartFile), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePhoto")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException{
		return new ResponseEntity<>(this.photoService.delete(id), HttpStatus.OK);
	}
}
