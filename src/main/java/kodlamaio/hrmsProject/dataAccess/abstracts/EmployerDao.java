package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Result findByEmail(String email);
	Result findByCompanyName(String companyName);
	Result findByWebAddress(String webAddress);
	Result findByPhoneNumber(String phoneNumber);
	Employer getById(int id);
}
