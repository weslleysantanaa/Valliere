package com.principedevalliere.repositories;

import com.principedevalliere.models.ChapterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChapterRepository extends JpaRepository<ChapterModel, UUID> {

    List<ChapterModel> findByBookTitle(String title);
}
