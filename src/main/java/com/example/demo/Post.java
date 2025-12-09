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

    public Post(long id, String title, int price, String author, String message, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }
}
