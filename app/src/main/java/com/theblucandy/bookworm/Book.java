package com.theblucandy.bookworm;

public class Book {
    private String title;
    private String author;
    private String price;
    private String thumbnail;
    private String description;

    public Book(String title, String author, String price, String thumbnail, String description) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }
}
