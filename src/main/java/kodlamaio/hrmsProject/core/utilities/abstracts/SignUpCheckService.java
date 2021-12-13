package kodlamaio.hrmsProject.core.utilities.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.User;

public interface SignUpCheckService {
	Result checkEmailFormat(User user);
	Result checkUniqueEmail(User user);
	Result checkPassword(User user, String passwordAgain);
}
