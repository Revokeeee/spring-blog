package com.example.blog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

public class PostTest {

    @Test
    public void testConstructorAndGetters() {
        User author = new User("Макс", "maks@example.com", "password");
        Post post = new Post("Заголовок", "Текст поста", author);

        assertEquals("Заголовок", post.getTitle());
        assertEquals("Текст поста", post.getContent());
        assertEquals(author, post.getAuthor());

        assertNotNull(post.getCreatedAt());
        assertTrue(post.getCreatedAt().isBefore(LocalDateTime.now().plusSeconds(1)));

        List<Comment> comments = post.getComments();
        assertNotNull(comments);
        assertTrue(comments.isEmpty());
    }
}
