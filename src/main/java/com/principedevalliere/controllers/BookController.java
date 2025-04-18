package com.principedevalliere.controllers;

import com.principedevalliere.dtos.BookDTO;
import com.principedevalliere.models.BookModel;
import com.principedevalliere.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDTO> getAllBooks() { return service.getAllBooks(); }

    // procurar como retornar o dto e não o model diretamente
    @GetMapping("/{id}")
    public Optional<BookModel> getBookById(@PathVariable(value = "id") long id){
        return service.getBookById(id);
    }
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO addBook(@RequestBody BookModel model) {
        return service.addBook(model);
    }
}
