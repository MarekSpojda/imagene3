package pl.marek.imagene3.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.marek.imagene3.model.User;
import pl.marek.imagene3.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    private final UserService userService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        User userFromDatabase = userService.getUserByUserid(user.getUserid());
        boolean passwordOK = passwordEncoder.matches(user.getPassword(), userFromDatabase.getPassword());

        if (passwordOK) {
            session.setAttribute("loggedIn", user.getUserid());
            return "Logged in, " + session.getAttribute("loggedIn");
        }
        return "Login failed";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedIn");
        return "Logged out";
    }
}
