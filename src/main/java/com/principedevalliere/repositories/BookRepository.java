package com.principedevalliere.repositories;

import com.principedevalliere.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
}
