package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrmsProject.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer>{

	@Modifying
	@Query("update Photo set photoUrl=:url where candidate.id=:id")
	int updatePhotoSetPhotoUrlForCandidate_id(@Param("url") String url,@Param("id") int id);
	
	
	@Query("From Photo p where p.candidate.id=:id")
	Photo getByPhotoCandidate_Id(int id);	
	
}
