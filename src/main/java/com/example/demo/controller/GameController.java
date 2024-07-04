package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtService;
import com.example.demo.entity.dto.GameDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/add")
    public ResponseEntity<?> addGameToList(@RequestParam Long gameId,
            @RequestHeader("Authorization") String token) {
        token = token.substring(7);
        String username = jwtService.extractUsername(token);
        Long userId = userService.findUserIdByUsername(username);

        userService.addGame(userId, gameId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<GameDTO>> getListGames(@PathVariable Long user_id,
            @RequestHeader("Authorization") String token) {
        token = token.substring(7);
        String username = jwtService.extractUsername(token);
        Long userIdToken = userService.findUserIdByUsername(username);

        if (!user_id.equals(userIdToken)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<GameDTO> games = userService.getList(user_id);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
}
