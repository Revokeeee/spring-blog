package com.example.blog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUsernameGetterSetter() {
        User user = new User();
        user.setUsername("Макс");
        assertEquals("Макс", user.getUsername());
    }
}
