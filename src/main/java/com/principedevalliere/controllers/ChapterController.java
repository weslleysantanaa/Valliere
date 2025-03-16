package com.principedevalliere.controllers;

import com.principedevalliere.model.ChapterModel;
import com.principedevalliere.repositories.ChapterRepository;
import com.principedevalliere.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    ChapterService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChapterModel> getAllChapters() {
        return service.getAllChapters();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ChapterModel> getChapter(@PathVariable Long id) {
        return service.getChapter(id);
    }
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChapterModel addChapter(@RequestBody ChapterModel chapter) {
        return service.createChapter(chapter);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ChapterModel updateChapter(@PathVariable Long id, ChapterModel chapter) throws Exception {
        return service.updateChapter(id, chapter);
    }
}
