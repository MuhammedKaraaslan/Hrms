package kodlamaio.hrmsProject.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.business.abstracts.EmployerCheckService;
import kodlamaio.hrmsProject.core.utilities.abstracts.SignUpCheckService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.entities.concretes.Employer;



@Service
public class EmployerCheckManager implements EmployerCheckService{
	
	private SignUpCheckService signUpCheckService;
	
	
	@Autowired
	public EmployerCheckManager(SignUpCheckService signUpCheckService) {
		super();
		this.signUpCheckService = signUpCheckService;
	}
	
	@Override
	public Result checkCompanyName(Employer employer) {
		if(employer.getCompanyName().isEmpty()) {
			return new ErrorResult("Company name can not be empty");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkWebAddress(Employer employer) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex,
		Pattern.CASE_INSENSITIVE);
		if(! (pattern.matcher(employer.getEmail()).find())) {
			return new ErrorResult("Invalid web address format");
		}
		else if(employer.getWebAddress().isEmpty()) {
			return new ErrorResult("Web site can not be empty");
		}			
		return new SuccessResult();		
		
	}

	@Override
	public Result checkMailDomain(Employer employer) {
//		 String regex = "^[A-Za-z0-9._%+-]+@" + employer.getWebAddress() +"$";
//	     Pattern pattern = Pattern.compile(regex);
//         Matcher matcher = pattern.matcher(employer.getEmail());
//         if(matcher.matches()) {
//        	 return new SuccessResult();
//         }
//         return new ErrorResult("Email address does not match with web address");        
		 String email = employer.getEmail().substring(employer.getEmail().indexOf("@") + 1);
		 String webAddress = employer.getWebAddress().substring(employer.getWebAddress().indexOf(".") + 1);
		 if(email.equals(webAddress)) {
			 return new SuccessResult();
		 }
		 return new ErrorResult("Email address does not match with web address");
		          
	}
	
	@Override
	public Result checkEmail(Employer employer) {
		if(! this.signUpCheckService.checkEmailFormat(employer).isSuccess()) {
			return new ErrorResult(this.signUpCheckService.checkEmailFormat(employer).getMessage());
		}
		else if (! this.signUpCheckService.checkUniqueEmail(employer).isSuccess()) {
			return new ErrorResult(this.signUpCheckService.checkUniqueEmail(employer).getMessage());
		}
		else if(! checkMailDomain(employer).isSuccess()) {
			return new ErrorResult(checkMailDomain(employer).getMessage());			
		}
		return new SuccessResult();
	}

	@Override
	public Result checkPhoneNumber(Employer employer) {
	    String regex 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$"
	      + "|^(\\d{3}[- .]?){2}?(\\d{2}[- .]?){2}$";
		Pattern pattern = Pattern.compile(regex,
		Pattern.CASE_INSENSITIVE);
		if(pattern.matcher(employer.getPhoneNumber()).find()) {
			return new SuccessResult();
		}
		return new ErrorResult("Invalid phone number");
	}


	@Override
	public Result checkPassword(Employer employer, String passwordAgain) {
		if (this.signUpCheckService.checkPassword(employer, passwordAgain).isSuccess()) {
			return new SuccessResult();
		} else {
			return new ErrorResult(this.signUpCheckService.checkPassword(employer, passwordAgain).getMessage());
		}
	}

	@Override
	public Result checkAll(Employer employer, String passwordAgain) {
		if(! (checkCompanyName(employer).isSuccess())) {
			return new ErrorResult(checkCompanyName(employer).getMessage());
		}
		else if(! (checkWebAddress(employer).isSuccess())) {
			return new ErrorResult(checkWebAddress(employer).getMessage());
		}
		else if(! (checkEmail(employer).isSuccess())) {
			return new ErrorResult(checkEmail(employer).getMessage());
		}
		else if(! (checkPhoneNumber(employer).isSuccess())) {
			return new ErrorResult(checkPhoneNumber(employer).getMessage());
		}
		else if(! (checkPassword(employer, passwordAgain).isSuccess())) {
			return new ErrorResult(checkPassword(employer, passwordAgain).getMessage());
		}
		return new SuccessResult();
	}


}


