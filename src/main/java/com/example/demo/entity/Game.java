package com.example.demo.entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    private Long id;

    private Long gameId;

    @ManyToMany(mappedBy = "games")
    List<User> users = new ArrayList<>();

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
