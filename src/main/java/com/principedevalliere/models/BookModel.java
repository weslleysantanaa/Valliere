package com.principedevalliere.models;

import com.principedevalliere.dtos.AuthorDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Table(name = "books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, length = 60)
    private String title;
    private String synopsis;

    @ManyToOne
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AuthorModel author;


    public BookModel() {}

    public BookModel(String title, String synopsis, AuthorModel author) {
        this.title = title;
        this.synopsis = synopsis;
        this.author = author;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getSynopsis() { return synopsis; }

    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public AuthorModel getAuthor() { return author; }

    public void setAuthor(AuthorModel author) { this.author = author; }
}

