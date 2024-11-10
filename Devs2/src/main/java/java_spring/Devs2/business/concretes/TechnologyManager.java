package java_spring.Devs2.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java_spring.Devs2.business.abstracts.TechnologyService;
import java_spring.Devs2.business.requests.CreateTechnologyRequest;
import java_spring.Devs2.business.requests.DeleteTechnologyRequest;
import java_spring.Devs2.business.requests.UpdateTechnologyRequest;
import java_spring.Devs2.business.responses.GetAllTechnologiesResponse;
import java_spring.Devs2.dataAccess.abstracts.ProgrammingLanguageRepository;
import java_spring.Devs2.dataAccess.abstracts.TechnologyRepository;
import java_spring.Devs2.entities.conretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	public TechnologyManager(TechnologyRepository technologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository=programmingLanguageRepository;
	}


	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technology = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> responses = new ArrayList<>();
		for(Technology tech:technology) {
			GetAllTechnologiesResponse getAllTechnologiesResponse = new GetAllTechnologiesResponse();
			getAllTechnologiesResponse.setId(tech.getId());
			getAllTechnologiesResponse.setName(tech.getName());
			getAllTechnologiesResponse.setLanguage_id(tech.getProgrammingLanguage().getId());
			responses.add(getAllTechnologiesResponse);
		}
		return responses;
	}


	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);
		
	}


	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		List<Technology> technology = technologyRepository.findAll();
		for(Technology tch:technology) {
			if(deleteTechnologyRequest.getId()==tch.getId()) {
				technologyRepository.delete(tch);
			}
		}
		
	}


	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = new Technology();
		technology.setId(updateTechnologyRequest.getTechnology_id());
		technology.setName(updateTechnologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguageRepository.findById(updateTechnologyRequest.getLanguage_id()).orElse(null));
		technologyRepository.save(technology);
	}

	

}
