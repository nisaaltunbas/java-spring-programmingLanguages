package java_spring.Devs2.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java_spring.Devs2.business.abstracts.ProgrammingLanguageService;
import java_spring.Devs2.business.requests.CreateLanguageRequest;
import java_spring.Devs2.business.requests.DeleteLanguageRequest;
import java_spring.Devs2.business.requests.GetLanguageById;
import java_spring.Devs2.business.requests.UpdateLanguageRequest;
import java_spring.Devs2.business.responses.GetAllLanguageResponse;
import java_spring.Devs2.business.responses.LanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public LanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.programmingLanguageService.add(createLanguageRequest);
	}
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		this.programmingLanguageService.update(updateLanguageRequest);
	}
	
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.programmingLanguageService.delete(deleteLanguageRequest);
	}
	@GetMapping("/getbyid")
	public LanguageResponse getLanguageById(GetLanguageById getLanguageById) {
		return programmingLanguageService.getLanguageById(getLanguageById);
	}
	

}
