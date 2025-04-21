package com.principedevalliere.models;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Table(name = "chapters")
public class ChapterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 60)
    private String title;

    @Lob
    @Column(nullable = false)
    private String body;

    @ManyToOne()
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BookModel book;


    public ChapterModel() {}

    public ChapterModel(String title, String body, BookModel book){
        this.title = title;
        this.body = body;
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public BookModel getBookModel() { return book; }

    public void setBookModel(BookModel bookModel) { this.book = bookModel; }
}
