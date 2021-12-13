package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.WorkStyle;

public interface WorkStyleDao extends JpaRepository<WorkStyle, Integer>{
	WorkStyle getById(int id);
}
