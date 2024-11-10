package java_spring.Devs2.business.abstracts;

import java.util.List;

import java_spring.Devs2.business.requests.CreateTechnologyRequest;
import java_spring.Devs2.business.requests.DeleteTechnologyRequest;
import java_spring.Devs2.business.requests.UpdateTechnologyRequest;
import java_spring.Devs2.business.responses.GetAllTechnologiesResponse;

public interface TechnologyService {
	List<GetAllTechnologiesResponse> getAll();
	void add(CreateTechnologyRequest createTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest);
}
