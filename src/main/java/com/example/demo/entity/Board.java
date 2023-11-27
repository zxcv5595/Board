package com.example.demo.entity;
import com.example.demo.global.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity {
	private Long id;
	
	private String writer;
	
	private String title;
	
	private String content;
	
	private Long views;
	// CREATE TABLE board(
	// id BIGINT NOT NULL AUTO_INCREMENT,
	// writer VARCHAR(20) NOT NULL,
	// title VARCHAR(20) NOT NULL,
	// content VARCHAR(255) NOT NULL,
	// VIEWS BIGINT NOT NULL DEFAULT 0,
	// created_at TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP,
	// modified_at TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	// INDEX (created_at),
	// PRIMARY KEY (id)
	// ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
	
	public void increaseViews() {
		this.views += 1;
	}
}
