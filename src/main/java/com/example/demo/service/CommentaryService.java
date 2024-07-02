package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Commentary;
import com.example.demo.repository.CommentaryRepository;
import com.github.slugify.Slugify;


@Service
public class CommentaryService {

    private Slugify slugify = Slugify.builder().build();
    

    @Autowired
    private CommentaryRepository commentaryRepository;

    public List<Commentary> getAll() {
        List<Commentary> commentaries = this.commentaryRepository.findAll();
        return commentaries;
    }

    public Commentary getOneById(Long id) {
        Commentary commentary = this.commentaryRepository.findById(id).get();
        return commentary;
    }

    public Commentary getOneBySlug(String slug) {
        Commentary commentary = this.commentaryRepository.findBySlug(slug);
        return commentary;
    }

    public Commentary createCommentary(Commentary commentary) {
        commentary.setSlug(slugify.slugify(commentary.getContent()));
        return this.commentaryRepository.save(commentary);
    }

    public void deleteCommentary(Long id) {
        this.commentaryRepository.deleteById(id);
    }
}
