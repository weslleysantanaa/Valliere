package com.principedevalliere.controllers;

import com.principedevalliere.models.ChapterModel;
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
    ChapterService chapterService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChapterModel> getAllChapters() {
        return chapterService.getAllChapters();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ChapterModel> getChapter(@PathVariable Long id) {
        return chapterService.getChapter(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChapterModel addChapter(@RequestBody ChapterModel chapter) {
        return chapterService.createChapter(chapter);
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChapterModel updateChapter(@PathVariable Long id, @RequestBody ChapterModel chapter) throws Exception {
        return chapterService.updateChapter(id, chapter);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteChapter(@PathVariable Long id) {
        chapterService.deleteChapter(id);
    }
}
