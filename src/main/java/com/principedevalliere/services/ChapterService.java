package com.principedevalliere.services;

import com.principedevalliere.dtos.ChapterDTO;
import com.principedevalliere.models.ChapterModel;
import com.principedevalliere.repositories.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChapterService {

    @Autowired
    ChapterRepository repository;

    public List<ChapterDTO> getAllChaptersByBookTitle(String bookTitle) {
        return repository.findByBookTitle(bookTitle).stream().map(this::convertChapterModelToDTO).toList();
    }

    public Optional<ChapterDTO> getChapter(UUID id) {
        return repository.findById(id).map(this::convertChapterModelToDTO);
    }

    public ChapterDTO createChapter(ChapterModel chapter) { return convertChapterModelToDTO(repository.save(chapter)); }

    public ChapterDTO updateChapter(UUID id, ChapterModel editedChapter) throws Exception {
        Optional<ChapterModel> searchedChapter = repository.findById(id);
        if (searchedChapter.isEmpty()) {
            return null;
        }
        ChapterModel chapter = searchedChapter.get();
        chapter.setTitle(editedChapter.getTitle());
        chapter.setBody(editedChapter.getBody());
        return convertChapterModelToDTO(repository.save(chapter));
    }

    public void deleteChapter(UUID id) {
        repository.deleteById(id);
    }

    public ChapterDTO convertChapterModelToDTO(ChapterModel chapterModel) {
        return new ChapterDTO(chapterModel.getTitle(), chapterModel.getBody());
    }
}
