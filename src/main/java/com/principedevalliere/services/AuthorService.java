package com.principedevalliere.services;

import com.principedevalliere.dtos.AuthorDTO;
import com.principedevalliere.models.AuthorModel;
import com.principedevalliere.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public List<AuthorDTO> getAllAuthors() {
        List<AuthorModel> authors = repository.findAll();

        return authors.stream()
                .map(this::convertAuthorModelToDTO).toList();
    }

    public AuthorDTO getAuthorByName(String name) {
        return convertAuthorModelToDTO(repository.findAuthorbyName(name));
    }

    public AuthorDTO convertAuthorModelToDTO(AuthorModel authorModel) {
        return new AuthorDTO(authorModel.getName());
    }

}
