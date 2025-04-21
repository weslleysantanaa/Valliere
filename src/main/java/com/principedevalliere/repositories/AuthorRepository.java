package com.principedevalliere.repositories;

import com.principedevalliere.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {

    @Query(value = "SELECT * from authors WHERE name = :name", nativeQuery = true)
    public AuthorModel findAuthorbyName(@Param("name") String name);

}
