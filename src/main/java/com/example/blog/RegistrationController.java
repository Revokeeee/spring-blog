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


    // Обробка відправленої форми
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session
    ) {
        User user = new User(username, email, password);
        users.add(user);
        session.setAttribute("currentUser", user); // Зберегти користувача в сесію
        return "redirect:/"; // Перенаправити на головну
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
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("currentUser", user);
                return "redirect:/"; // Після входу — на головну
            }
        }
        model.addAttribute("message", "Невірні дані для входу.");
        return "login"; // Якщо помилка — залишитись
    }


}
