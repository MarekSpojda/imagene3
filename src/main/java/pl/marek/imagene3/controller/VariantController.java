package pl.marek.imagene3.controller;

import org.springframework.web.bind.annotation.*;
import pl.marek.imagene3.model.User;
import pl.marek.imagene3.model.Variant;
import pl.marek.imagene3.service.UserService;
import pl.marek.imagene3.service.VariantService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/variant")
public class VariantController {
    private final VariantService variantService;
    private final UserService userService;
    private final HttpSession session;

    public VariantController(VariantService variantService, UserService userService, HttpSession session) {
        this.variantService = variantService;
        this.userService = userService;
        this.session = session;
    }

    @GetMapping
    public List<String> getAllVariants() {
        try {
            return variantService.getAllVariantsDescriptionsOfLoggedUser(session);
        } catch (Exception ignored) {
        }

        List<String> userNotLoggedInVaraintList = new ArrayList<>();
        userNotLoggedInVaraintList.add("Failed to display list of variants of logged user");
        return userNotLoggedInVaraintList;
    }

    @PostMapping
    public String addVariant(@RequestBody Variant variant) {
        if (!variantService.checkIfVariantExist(variant)) {
            variantService.saveOrUpdate(variant);
            return "Variant created";
        }

        return "Failed to create variant";
    }

    @PostMapping("/{variantid}")
    public String addVariantToUser(@PathVariable String variantid, HttpSession session) {
        try {
            User user = userService.getUserByUserid((String) session.getAttribute("loggedIn"));
            Variant variant = variantService.geVariantById(Long.parseLong(variantid));
            List<Variant> variantsOfLoggedUser = user.getVariants();
            if (!variantService.checkIfVariantIsOnTheList(variant, variantsOfLoggedUser)) {
                variantsOfLoggedUser.add(variant);
                userService.saveOrUpdate(user);
            } else {
                return "Failed to add variant to user";
            }
        } catch (Exception e) {
            return "Failed to add variant to user";
        }

        return "Variant added to user";
    }
}
