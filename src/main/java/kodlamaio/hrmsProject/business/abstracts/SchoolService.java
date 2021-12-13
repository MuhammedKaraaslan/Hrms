package kodlamaio.hrmsProject.business.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.School;

public interface SchoolService {
	Result checkCandidate(School school);
	Result checkName(School school);
	Result checkDepartment(School school);
	Result checkEntryYear(School school);
	Result checkAll(School school);
	Result add(School school);
	DataResult<List<School>> getAllByCandidateIdOrderByGraduationYearDesc(int id);
	Result update(School school);
}
