package com.principedevalliere.repositories;

import com.principedevalliere.models.ChapterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<ChapterModel, Long> {
}
