package com.example.blog;

import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import jakarta.persistence.CascadeType;


import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model, HttpSession session) {
        Post post = postRepository.findById(id).orElseThrow();
        model.addAttribute("post", post);
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        return "post";
    }


    @PostMapping("/add-post")
    public String addPost(@RequestParam String title,
                          @RequestParam String content,
                          HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            postRepository.save(new Post(title, content, user));
        }
        return "redirect:/";
    }

    @PostMapping("/posts/{id}/comment")
    public String addComment(@PathVariable Long id,
                             @RequestParam String content,
                             HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            Post post = postRepository.findById(id).orElseThrow();
            Comment comment = new Comment(content, user, post);
            commentRepository.save(comment);
        }
        return "redirect:/posts/" + id;
    }

}
