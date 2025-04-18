package com.principedevalliere.models;
import jakarta.persistence.*;

@Entity
@Table(name = "chapters")
public class ChapterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String title;

    @Lob
    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(nullable = false)
    private BookModel book_id;


    public ChapterModel() {}

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

    public BookModel getBookModel() { return book_id; }

    public void setBookModel(BookModel bookModel) { this.book_id = bookModel; }
}
