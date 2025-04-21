package com.principedevalliere.dtos;

import com.principedevalliere.models.AuthorModel;

public class BookDTO {

    private String title;
    private String synopsis;
    private String authorName;

    public BookDTO() {}

    public BookDTO(String title, String synopsis, String authorName) {
        this.title = title;
        this.synopsis = synopsis;
        this.authorName = authorName;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getSynopsis() { return synopsis; }

    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public String getAuthorName() { return authorName; }

    public void setAuthorName(String author) { this.authorName = author; }
}

