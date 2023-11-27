package com.example.demo.base.domain;

import java.time.LocalDateTime;

public abstract class BaseEntity {

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public BaseEntity() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}