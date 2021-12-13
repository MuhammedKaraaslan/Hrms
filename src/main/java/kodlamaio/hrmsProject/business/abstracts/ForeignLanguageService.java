package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	Result checkCandidate(ForeignLanguage foreignLanguage);
	Result checkName(ForeignLanguage foreignLanguage);
	Result checkLevel(ForeignLanguage foreignLanguage);
	Result checkAll(ForeignLanguage foreignLanguage);
	Result add(ForeignLanguage foreignLanguage);
	Result update(ForeignLanguage foreignLanguage);
}
