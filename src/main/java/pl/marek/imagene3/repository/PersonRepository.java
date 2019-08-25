package pl.marek.imagene3.repository;

import org.springframework.data.repository.CrudRepository;
import pl.marek.imagene3.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
