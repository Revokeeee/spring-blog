package com.example.blog;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostRepository {

    private final List<Post> posts = new ArrayList<>();

    public List<Post> getAllPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
