package pl.marek.imagene3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.marek.imagene3.model.Variant;

import java.util.List;

public interface VariantRepository extends CrudRepository<Variant, Long> {
    @Query("select v from Variant v where v.position=?1")
    List<Variant> findByPosition(long position);
}
