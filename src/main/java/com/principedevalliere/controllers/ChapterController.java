package com.principedevalliere.controllers;

import com.principedevalliere.dtos.ChapterDTO;
import com.principedevalliere.models.ChapterModel;
import com.principedevalliere.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/books/{bookTitle}/chapter")
public class ChapterController {

    @Autowired
    ChapterService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChapterDTO> getAllChaptersByBookName(@PathVariable String bookTitle) {
        return service.getAllChaptersByBookTitle(bookTitle);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ChapterDTO> getChapter(@PathVariable String bookTitle, @PathVariable UUID id) {
        return service.getChapterByIdInBookTitle(bookTitle, id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChapterDTO addChapter(@RequestBody ChapterModel chapter) {
        return service.createChapter(chapter);
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChapterDTO updateChapter(@PathVariable UUID id, @RequestBody ChapterModel chapter) throws Exception {
        return service.updateChapter(id, chapter);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteChapter(@PathVariable UUID id) {
        service.deleteChapter(id);
        return ResponseEntity.ok("Capítulo deletado com sucesso");
    }
}
