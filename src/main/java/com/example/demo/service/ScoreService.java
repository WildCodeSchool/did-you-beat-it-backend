package com.example.demo.service;

import com.example.demo.entity.Score;
import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> findAll(){
        return scoreRepository.findAll();
    }

    public Optional<Score> findById(Long id) {
        return scoreRepository.findById(id);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteById(Long id) {
        scoreRepository.deleteById(id);
    }
}
