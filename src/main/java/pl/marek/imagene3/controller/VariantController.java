package pl.marek.imagene3.controller;

import org.springframework.web.bind.annotation.*;
import pl.marek.imagene3.model.Variant;
import pl.marek.imagene3.service.VariantService;

import java.util.List;

@RestController
@RequestMapping("/variant")
public class VariantController {
    //TODO prevent update of variant
    private final VariantService variantService;

    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @GetMapping
    public List<Variant> getAllVariants() {
        return variantService.getAllVariants();
    }

    @PostMapping
    public String addVariant(@RequestBody Variant variant) {
        try {
            variantService.saveOrUpdate(variant);
            return "Variant added";
        } catch (Exception ignored) {
        }

        return "Failed to add variant";
    }
}
