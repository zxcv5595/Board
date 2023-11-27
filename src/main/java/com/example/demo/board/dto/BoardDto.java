package com.example.demo.board.dto;

import com.example.demo.board.domain.Board;
import java.time.LocalDate;

public class BoardDto {

    private Long id;

    private String writer;

    private String title;
    private String content;
    private LocalDate createdAt;
    private Long views;

    public BoardDto() {
    }

    public BoardDto(Long id, String writer, String title, String content, LocalDate createdAt,
        Long views) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.views = views;
    }

    public static BoardDto from(Board board) {
        return new BoardDto(board.getId(), board.getWriter(), board.getTitle(), board.getContent(),
            board.getCreatedAt().toLocalDate(),
            board.getViews());
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Long getViews() {
        return views;
    }
}
