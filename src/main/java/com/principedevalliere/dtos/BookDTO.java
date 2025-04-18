package com.principedevalliere.dtos;

public class BookDTO {

    private String title;
    private String sinopsis;
    private String author;

    public BookDTO() {}

    public BookDTO(String title, String sinopsis, String author) {
        this.title = title;
        this.sinopsis = sinopsis;
        this.author = author;
    }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    public String getSinopsis() { return this.sinopsis; }

    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public String getAuthor() { return this.author; }

    public void setAuthor(String author) { this.sinopsis = author; }
}

