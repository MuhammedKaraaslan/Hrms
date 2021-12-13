/*package kodlamaio.hrmsProject.core.adapters.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.core.adapters.abstracts.MernisCheckService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = true;
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")), candidate.getBirthYear());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(result) {
			return new SuccessResult();
		} 
		else {
			return new ErrorResult("Error in Mernis verification");
		}
	}

}
*/