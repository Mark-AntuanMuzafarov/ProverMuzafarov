package com.example.demo;

import java.time.LocalDateTime;

public class Post {
    long id;
    String title;
    int price;
    String author;
    String message;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Post(long id, String title, int price, String author, String message) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
