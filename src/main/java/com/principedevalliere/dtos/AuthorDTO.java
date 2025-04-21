package com.principedevalliere.dtos;

import com.principedevalliere.models.AuthorModel;

public class AuthorDTO {
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
