package java_spring.Devs2.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java_spring.Devs2.business.abstracts.TechnologyService;
import java_spring.Devs2.business.requests.CreateTechnologyRequest;
import java_spring.Devs2.business.requests.DeleteTechnologyRequest;
import java_spring.Devs2.business.requests.UpdateTechnologyRequest;
import java_spring.Devs2.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll(){
		return technologyService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	@PostMapping("/put")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest);
	}
	@PostMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(deleteTechnologyRequest);
	}
	
	

}
