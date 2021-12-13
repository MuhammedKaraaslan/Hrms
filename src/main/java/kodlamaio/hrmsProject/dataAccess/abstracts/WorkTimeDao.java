package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.WorkTime;

public interface WorkTimeDao extends JpaRepository<WorkTime, Integer> {
	WorkTime getById(int id);
}
