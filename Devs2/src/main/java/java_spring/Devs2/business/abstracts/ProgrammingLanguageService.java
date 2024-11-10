package java_spring.Devs2.business.abstracts;

import java.util.List;

import java_spring.Devs2.business.requests.CreateLanguageRequest;
import java_spring.Devs2.business.requests.DeleteLanguageRequest;
import java_spring.Devs2.business.requests.GetLanguageById;
import java_spring.Devs2.business.requests.UpdateLanguageRequest;
import java_spring.Devs2.business.responses.GetAllLanguageResponse;
import java_spring.Devs2.business.responses.LanguageResponse;

public interface ProgrammingLanguageService {
	List<GetAllLanguageResponse> getAll();
	void add(CreateLanguageRequest createLanguageRequest);
	void update(UpdateLanguageRequest languageRequest);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
    LanguageResponse getLanguageById(GetLanguageById getLanguageById);

}
