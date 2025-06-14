package com.example.blog.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PostPageTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddCommentWithLoginFix() throws InterruptedException {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("username")).sendKeys("Revoke");
        driver.findElement(By.name("password")).sendKeys("123123123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".post-link.post-preview")).click();

        Thread.sleep(1000);
        driver.findElement(By.name("content")).sendKeys("Test comment from Selenium");
        driver.findElement(By.xpath("//button[text()='Додати коментар']")).click();

        Thread.sleep(1000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
