package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "commentary")
public class Commentary {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String author;
    private Long UserId;
    private Long GameId;

    public Commentary() {
    }

    public Commentary(String content, String author, Long UserId, Long GameId) {
        this.content = content;
        this.author = author;
        this.UserId = UserId;
        this.GameId = GameId;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getUserId() {
        return this.UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public Long getGameId() {
        return this.GameId;
    }

    public void setGameId(Long GameId) {
        this.GameId = GameId;
    }

}
