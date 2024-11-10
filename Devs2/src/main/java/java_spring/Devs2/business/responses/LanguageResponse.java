package java_spring.Devs2.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResponse {
	private String name;
	private List<TechnologyResponse> technologies;
}
