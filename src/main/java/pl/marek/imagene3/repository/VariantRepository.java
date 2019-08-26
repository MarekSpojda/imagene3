package pl.marek.imagene3.repository;

import org.springframework.data.repository.CrudRepository;
import pl.marek.imagene3.model.Variant;

public interface VariantRepository extends CrudRepository<Variant, Long> {
}
