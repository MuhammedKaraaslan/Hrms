package kodlamaio.hrmsProject.core.utilities.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.core.utilities.abstracts.EmailVerificationService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.entities.concretes.User;

@Service
public class FakeEmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(User user) {
		return new SuccessResult();
	}

}
