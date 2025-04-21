package com.principedevalliere.services;

import com.principedevalliere.dtos.BookDTO;
import com.principedevalliere.models.BookModel;
import com.principedevalliere.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> getAllBooks() {
        List<BookModel> books = repository.findAll();
        return books.stream().map(this::convertBookModelToDTO).toList();
    }

    // o que é optional<>? Procurar alternativas de não usar ele e declarar explicitamente o retorno como BookDTO
    public Optional<BookModel> getBookById(UUID id) { return repository.findById(id);}

    // talvez quando for adicionar o frontend isso aqui nao funcione porque vou precisar
    // transformar de DTO pra model pra salvar no banco. Processo inverso
    public BookDTO addBook(BookModel book) {
        repository.save(book);
        return convertBookModelToDTO(book);
    }

    private BookDTO convertBookModelToDTO(BookModel bookModel) {
        return new BookDTO(bookModel.getTitle(), bookModel.getSynopsis(), bookModel.getAuthor().getName());
    }
}
