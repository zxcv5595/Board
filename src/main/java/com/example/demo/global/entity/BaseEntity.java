package com.example.demo.global.entity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
}