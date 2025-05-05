package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/add-post")
    public String showAddPostForm(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }
        return "newpost";
    }

    @PostMapping("/add-post")
    public String addPost(@RequestParam String title, @RequestParam String content, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            postRepository.addPost(new Post(title, content, user.getUsername()));
        }
        return "redirect:/";
    }
}
