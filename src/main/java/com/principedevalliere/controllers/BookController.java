package com.principedevalliere.controllers;

import com.principedevalliere.dtos.BookDTO;
import com.principedevalliere.models.BookModel;
import com.principedevalliere.services.BookService;
import com.principedevalliere.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> getAllBooks() { return bookService.getAllBooks(); }

    // procurar como retornar o dto e não o model diretamente
    @GetMapping("/{id}")
    public Optional<BookModel> getBookById(@PathVariable(value = "id") UUID id){
        return bookService.getBookById(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO addBook(@RequestBody BookModel model) {
        return bookService.addBook(model);
    }
}
