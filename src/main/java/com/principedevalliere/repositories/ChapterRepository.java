package com.principedevalliere.repositories;

import com.principedevalliere.models.ChapterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChapterRepository extends JpaRepository<ChapterModel, UUID> {

    List<ChapterModel> findAllChaptersByBookTitle(String bookTitle);

    @Query(value = "SELECT chapter FROM ChapterModel chapter WHERE chapter.book.title = :bookTitle and chapter.id = :id")
    Optional<ChapterModel> findChapterByIdInBookTitle(@Param(value = "bookTitle") String bookTitle, @Param(value = "id") UUID id);
}
