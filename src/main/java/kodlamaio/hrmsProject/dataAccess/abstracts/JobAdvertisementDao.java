package kodlamaio.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	@Query("From JobAdvertisement where id=:id")
	JobAdvertisement getById(int id);
	
	List<JobAdvertisement> getByIsActive(boolean isActive);
	
	List<JobAdvertisement> getByIsActiveOrderByDeadlineDate(boolean isActive);
	
	@Query("From JobAdvertisement where employer.id=:employerId")
	List<JobAdvertisement> getByEmployer_IdAndIsActive(int employerId);
}