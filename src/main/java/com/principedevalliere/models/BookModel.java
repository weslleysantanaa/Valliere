package com.principedevalliere.models;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, length = 60)
    private String title;

    private String sinopsis;

    @Column(nullable = false)
    private String author;

    public BookModel() {}

    public BookModel(String title, String sinopsis, String author) {
        this.title = title;
        this.sinopsis = sinopsis;
        this.author = author;
    }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    public String getSinopsis() { return this.sinopsis; }

    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public String getAuthor() { return this.author; }

    public void setAuthor(String author) { this.author = author; }
}

