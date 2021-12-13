package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.LinkAddress;

public interface LinkAddressDao extends JpaRepository<LinkAddress, Integer>{
	LinkAddress getById(int id);
}
