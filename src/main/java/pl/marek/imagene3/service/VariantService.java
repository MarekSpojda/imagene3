package pl.marek.imagene3.service;

import org.springframework.stereotype.Service;
import pl.marek.imagene3.model.Variant;
import pl.marek.imagene3.repository.VariantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariantService {
    private final VariantRepository variantRepository;

    public VariantService(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    public List<Variant> getAllVariants() {
        List<Variant> variants = new ArrayList<Variant>();
        variantRepository.findAll().forEach(variant -> variants.add(variant));
        return variants;
    }

    public Variant geVariantById(Long id) {
        return variantRepository.findById(id).get();
    }

    public void saveOrUpdate(Variant variant) {
        variantRepository.save(variant);
    }

    public void delete(Long id) {
        variantRepository.deleteById(id);
    }
}
