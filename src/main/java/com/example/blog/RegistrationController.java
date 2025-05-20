package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    // Тимчасовий список для зберігання користувачів (імітація бази даних)
    private List<User> users = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Відображення форми реєстрації
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("message", "Користувач з таким імʼям вже існує.");
            return "register";
        }

        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("message", "Email вже використовується.");
            return "register";
        }

        User user = new User(username, email, password);
        userRepository.save(user);
        session.setAttribute("currentUser", user);
        return "redirect:/";
    }



    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("currentUser", user);
            return "redirect:/";
        }
        model.addAttribute("message", "Невірне імʼя користувача або пароль.");
        return "login";
    }



}
