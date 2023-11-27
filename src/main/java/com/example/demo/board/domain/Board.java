package com.example.demo.board.domain;

import com.example.demo.base.domain.BaseEntity;

public class Board extends BaseEntity {

    private Long id;

    private String writer;

    private String title;

    private String content;
    private Long views;

    public Board() {
    }

    public Board(Long id, String writer, String title, String content, Long views) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getViews() {
        return views;
    }

    public void increaseViews() {
        this.views += 1;
    }

//     CREATE TABLE board(
//     id BIGINT NOT NULL AUTO_INCREMENT,
//     writer VARCHAR(20) NOT NULL,
//     title VARCHAR(20) NOT NULL,
//     content VARCHAR(255) NOT NULL,
//     VIEWS BIGINT NOT NULL DEFAULT 0,
//     created_at TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP,
//     modified_at TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//     INDEX (created_at),
//     PRIMARY KEY (id)
//     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
}
