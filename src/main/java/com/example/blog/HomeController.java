package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PostRepository postRepository;

    public HomeController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postRepository.getAllPosts());
        return "home";
    }
}
