package com.example.blog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage {
    private WebDriver driver;

    // Конструктор
    public PostPage(WebDriver driver) {
        this.driver = driver;
    }

    // Додає коментар
    public void addComment(String commentText) {
        driver.findElement(By.name("content")).clear();
        driver.findElement(By.name("content")).sendKeys(commentText);
        driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Додати коментар')]")).click();
    }

    // Перевіряє, чи присутній коментар
    public boolean isCommentPresent(String commentText) {
        return driver.getPageSource().contains(commentText);
    }
}
