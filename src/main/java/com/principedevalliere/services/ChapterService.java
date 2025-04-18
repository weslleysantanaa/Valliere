package com.principedevalliere.services;

import com.principedevalliere.models.ChapterModel;
import com.principedevalliere.repositories.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterService {

    @Autowired
    ChapterRepository repository;

    public List<ChapterModel> getAllChapters() {
        return repository.findAll();
    }

    public Optional<ChapterModel> getChapter(Long id) {
        return repository.findById(id);
    }

    public ChapterModel createChapter(ChapterModel chapter) {
        return repository.save(chapter);
    }

    public ChapterModel updateChapter(Long id, ChapterModel editedChapter) throws Exception {
        Optional<ChapterModel> searchedChapter = repository.findById(id);
        if (searchedChapter.isEmpty()) {
            return null;
        }
        ChapterModel chapter = searchedChapter.get();
        chapter.setTitle(editedChapter.getTitle());
        chapter.setBody(editedChapter.getBody());
        return repository.save(chapter);
    }

    public void deleteChapter(Long id) {
        repository.deleteById(id);
    }
}
