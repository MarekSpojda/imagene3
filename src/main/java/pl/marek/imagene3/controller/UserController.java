package pl.marek.imagene3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.marek.imagene3.model.User;
import pl.marek.imagene3.service.UserService;
import pl.marek.imagene3.utils.CommonLogic;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@RequestBody String password) throws Exception {
        if (password.length() < 8) {
            return "Password length less than 8";
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(CommonLogic.checkPassword(password)));
        boolean isUnique = false;
        while (!isUnique) {
            try {
                user.setUserid(CommonLogic.makeUserId());
                userService.saveOrUpdate(user);
                isUnique = true;
            } catch (Exception e) {
                //noinspection ConstantConditions
                isUnique = false;
            }
        }
        return "User created";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
