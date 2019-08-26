package pl.marek.imagene3.service;

import org.springframework.stereotype.Service;
import pl.marek.imagene3.model.User;
import pl.marek.imagene3.model.Variant;
import pl.marek.imagene3.repository.VariantRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class VariantService {
    private final VariantRepository variantRepository;
    private final UserService userService;

    public VariantService(VariantRepository variantRepository, UserService userService) {
        this.variantRepository = variantRepository;
        this.userService = userService;
    }

    public List<Variant> getAllVariants() {
        List<Variant> variants = new ArrayList<Variant>();
        variantRepository.findAll().forEach(variant -> variants.add(variant));
        return variants;
    }

    public Variant geVariantById(Long id) {
        return variantRepository.findById(id).get();
    }

    public boolean checkIfVariantExist(Variant variant) {
        List<Variant> variants = variantRepository.findByPosition(variant.getPosition());
        for (Variant variantFromList : variants) {
            boolean alteration = variant.getAlteration().equals(variantFromList.getAlteration());
            boolean chromosome = variant.getChromosome().equals(variantFromList.getChromosome());
            if (alteration && chromosome) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfVariantIsOnTheList(Variant variant, List<Variant> variants) {
        for (Variant variantFromList : variants) {
            boolean alteration = variant.getAlteration().equals(variantFromList.getAlteration());
            boolean chromosome = variant.getChromosome().equals(variantFromList.getChromosome());
            boolean position = (variant.getPosition() == variantFromList.getPosition());
            if (alteration && chromosome && position) {
                return true;
            }
        }
        return false;
    }

    public void saveOrUpdate(Variant variant) {
        variantRepository.save(variant);
    }

    public void delete(Long id) {
        variantRepository.deleteById(id);
    }

    public List<String> getAllVariantsDescriptionsOfLoggedUser(HttpSession session) {
        User user = userService.getUserByUserid((String) session.getAttribute("loggedIn"));
        List<String> loggedUserVariantsDescriptions = new ArrayList<>();
        for (Variant variant : user.getVariants()) {
            loggedUserVariantsDescriptions.add(variant.getDescription());
        }
        return loggedUserVariantsDescriptions;
    }
}
