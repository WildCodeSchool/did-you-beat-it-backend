package com.example.demo.controller;

import com.example.demo.entity.Score;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        Optional<Score> score = scoreService.findById(id);
        return score.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreService.save(score);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable Long id, @RequestBody Score scoreDetails) {
        Optional<Score> updatedScore = scoreService.update(id, scoreDetails);
        return updatedScore.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        if (!scoreService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        scoreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
