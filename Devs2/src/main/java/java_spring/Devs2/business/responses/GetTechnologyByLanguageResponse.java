package java_spring.Devs2.business.responses;

import java_spring.Devs2.entities.conretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTechnologyByLanguageResponse {
	private ProgrammingLanguage programmingLanguage;

}
