package java_spring.Devs2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java_spring.Devs2.entities.conretes.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
