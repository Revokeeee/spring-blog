package com.example.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // За потреби: List<Post> findByAuthor(User user);
}
