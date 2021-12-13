package kodlamaio.hrmsProject.core.utilities.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.User;

public interface EmailVerificationService {
	Result verifyEmail(User user);
}
