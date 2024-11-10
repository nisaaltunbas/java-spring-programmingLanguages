package java_spring.Devs2.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java_spring.Devs2.business.abstracts.ProgrammingLanguageService;
import java_spring.Devs2.business.requests.CreateLanguageRequest;
import java_spring.Devs2.business.requests.DeleteLanguageRequest;
import java_spring.Devs2.business.requests.GetLanguageById;
import java_spring.Devs2.business.requests.UpdateLanguageRequest;
import java_spring.Devs2.business.responses.GetAllLanguageResponse;
import java_spring.Devs2.business.responses.LanguageResponse;
import java_spring.Devs2.business.responses.TechnologyResponse;
import java_spring.Devs2.dataAccess.abstracts.ProgrammingLanguageRepository;
import java_spring.Devs2.entities.conretes.ProgrammingLanguage;
import java_spring.Devs2.entities.conretes.Technology;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}


	@Override
	public List<GetAllLanguageResponse> getAll() {
		return LanguageMapper(programmingLanguageRepository.findAll());
	}


	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		ProgrammingLanguage language = new ProgrammingLanguage();
		language.setName(createLanguageRequest.getName());
		this.programmingLanguageRepository.save(language);
		
	}


	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		ProgrammingLanguage language = new ProgrammingLanguage();
		language.setId(updateLanguageRequest.getId());
		language.setName(updateLanguageRequest.getName());
		this.programmingLanguageRepository.save(language);
		
	}


	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		List<ProgrammingLanguage> language = programmingLanguageRepository.findAll();
		for(ProgrammingLanguage lng : language) {
			if(deleteLanguageRequest.getId()==lng.getId()) {
				programmingLanguageRepository.delete(lng);
			}
		}
		
	}


	@Override
	public LanguageResponse getLanguageById(GetLanguageById getLanguageById) {
		ProgrammingLanguage language = new ProgrammingLanguage();
		List<TechnologyResponse> technologyResponse = new ArrayList<>();
		for(Technology technology:language.getTechnologies()) {
			TechnologyResponse response = new TechnologyResponse();
			response.setId(technology.getId());
			response.setName(technology.getName());
			technologyResponse.add(response);
		}
		LanguageResponse languageResponse = new LanguageResponse();
		languageResponse.setName(language.getName());
		languageResponse.setTechnologies(technologyResponse);
		return languageResponse;
	}
	
	private List<GetAllLanguageResponse> LanguageMapper(List<ProgrammingLanguage> language){
		List<GetAllLanguageResponse> response = new ArrayList<GetAllLanguageResponse>();
		for(ProgrammingLanguage request:language) {
			GetAllLanguageResponse getAllLanguageResponse = new GetAllLanguageResponse();
			getAllLanguageResponse.setId(request.getId());
			getAllLanguageResponse.setName(request.getName());
			
			response.add(getAllLanguageResponse);
		}
		return response;
		
	}

	

}
