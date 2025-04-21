package com.principedevalliere.controllers;

import com.principedevalliere.dtos.AuthorDTO;
import com.principedevalliere.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorDTO> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthorDTO getAuthorByName(@PathVariable(value = "name") String name) {
        return service.getAuthorByName(name);
    }

}
